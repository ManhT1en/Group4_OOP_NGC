package com.project.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; 
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login"; 
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
