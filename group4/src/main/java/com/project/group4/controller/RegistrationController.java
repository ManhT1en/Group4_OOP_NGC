package com.project.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String registerCourse() {
        return "register"; // Tên file FXML cho đăng ký môn
    }
}
