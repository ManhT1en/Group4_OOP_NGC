package com.project.group4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.group4.models.Course;
import com.project.group4.service.CourseService;

@Controller
public class RegistrationController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/register")
    public String registerCourse(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "register"; // Tên file HTML cho đăng ký môn
    }

    @PostMapping("/register")
    public String registerCourse(@RequestParam Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            // Logic đăng ký môn học
            model.addAttribute("message", "Đăng ký môn học thành công!");
        } else {
            model.addAttribute("message", "Môn học không tồn tại!");
        }
        model.addAttribute("courses", courseService.getAllCourses());
        return "register";
    }
}