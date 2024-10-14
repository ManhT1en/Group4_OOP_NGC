package com.project.group4.controller;

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

import com.project.group4.models.Course;
import com.project.group4.models.Student;
import com.project.group4.repository.CourseRepository;
import com.project.group4.repository.StudentRepository;
import com.project.group4.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    // Hiển thị danh sách sinh viên
    @GetMapping
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAll();
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
    @GetMapping("/{id}/courses")
    public String showStudentCourses(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            List<Course> courses = student.getCourses(); // Lấy danh sách khóa học của sinh viên
            model.addAttribute("courses", courses);
            model.addAttribute("student", student);
            return "studentCourses"; // Trả về view hiển thị danh sách môn học
        } else {
            return "redirect:/students?error=notfound";
        }
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
