package com.project.group4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.group4.models.Student;
import com.project.group4.models.StudentCourse;
import com.project.group4.repository.StudentCourseRepository;
import com.project.group4.repository.StudentRepository;
import com.project.group4.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private StudentCourseRepository studentCourseRepository;

    // Hiển thị danh sách sinh viên
    @GetMapping
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            List<StudentCourse> studentCourses = studentCourseRepository.findByStudentId(student.getId());
            student.setGpa(calculateGPA(studentCourses));
        }
        model.addAttribute("students", students);
        return "students"; 
    }

    // Thêm sinh viên mới
    @PostMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam String studentId) {
        Student student = new Student(name, studentId);
        studentRepository.save(student);
        return "redirect:/students"; 
    }

    // Hiển thị danh sách các môn học của sinh viên
    // Hiển thị danh sách các môn học của sinh viên
    @GetMapping("/{id}/courses")
    public String showStudentCourses(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            List<StudentCourse> studentCourses = studentCourseRepository.findByStudentId(id); // Lấy danh sách khóa học của sinh viên
            model.addAttribute("studentCourses", studentCourses);
            model.addAttribute("gpa", calculateGPA(studentCourses));
            model.addAttribute("student", student);
            return "studentCourses"; // Trả về view hiển thị danh sách môn học
        } else {
            return "redirect:/students?error=notfound";
        }
    }

    private double calculateGPA(List<StudentCourse> studentCourses) {
        if (studentCourses.isEmpty()) {
            return 0.0;
        }
        double totalGrades = 0.0;
        int validCoursesCount = 0;
        for (StudentCourse course : studentCourses) {
            Double grade = course.getGrade();
            if (grade != null) {
                totalGrades += convertTo4PointScale(grade);
                validCoursesCount++;
            }
        }
        return validCoursesCount > 0 ? totalGrades / validCoursesCount : 0.0;
    }

    private double convertTo4PointScale(double grade) {
        if (grade >= 8.5) {
            return 4.0;
        } else if (grade >= 7.0) {
            return 3.0;
        } else if (grade >= 5.5) {
            return 2.0;
        } else if (grade >= 4.0) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    @GetMapping("/filter")
    public String filterStudentsByGpa(@RequestParam double gpa, Model model) {
        List<Student> students = studentRepository.findAll();
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            List<StudentCourse> studentCourses = studentCourseRepository.findByStudentId(student.getId());
            double calculatedGpa = calculateGPA(studentCourses);
            student.setGpa(calculatedGpa);
            if (calculatedGpa >= gpa) {
                filteredStudents.add(student);
            }
        }
        model.addAttribute("students", filteredStudents);
        return "students";
    }

    @Autowired
    private StudentService studentService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
