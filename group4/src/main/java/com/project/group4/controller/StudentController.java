package com.project.group4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.group4.models.Student;
import com.project.group4.repository.StudentRepository;

@Controller
@RequestMapping("/students") 
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students"; 
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name, 
                             @RequestParam String studentId, 
                             @RequestParam double gpa) {
        Student student = new Student(name, studentId, gpa);
        studentRepository.save(student);
        return "redirect:/students"; 
    }

    @GetMapping("/filter")
    public String filterByGpa(@RequestParam double gpa, Model model) {
        List<Student> filteredStudents = studentRepository.findByGpaGreaterThanEqual(gpa);
        model.addAttribute("students", filteredStudents); 
        return "students"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "redirect:/students"; // Redirect về danh sách sinh viên sau khi xóa
        } else {
            // Xử lý khi không tìm thấy sinh viên
            return "redirect:/students?error=notfound"; // Redirect với thông báo lỗi
        }
    }

    @GetMapping("/{id}/courses")
    public List<String> showStudentCourses(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return student.getCourses().stream()
                .map(course -> course.getCourseName())
                .toList();
        }
        return null;
    }
}
