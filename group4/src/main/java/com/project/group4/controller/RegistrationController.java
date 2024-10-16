package com.project.group4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.group4.models.Course;
import com.project.group4.models.Student;
import com.project.group4.models.StudentCourse;
import com.project.group4.service.CourseService;
import com.project.group4.service.StudentService;
import com.project.group4.service.StudentCourseService;

@Controller
public class RegistrationController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/register")
    public String registerCourse(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("students", studentService.getAllStudents());
        return "register"; // Tên file HTML cho đăng ký môn
    }

    @PostMapping("/register")
    public String registerCourse(@RequestParam Long courseId, @RequestParam Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);

        if (studentCourseService.isStudentRegisteredForCourse(student, course)) {
            model.addAttribute("message", "Sinh viên đã đăng ký môn học này.");
            return "register";
        }

        studentCourseService.registerStudentForCourse(student, course);
        model.addAttribute("message", "Đăng ký môn học thành công.");
        return "register";
    }
}