package com.project.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    private final String DEFAULT_USERNAME = "admin"; 
    private final String DEFAULT_PASSWORD = "1"; 

    @GetMapping("/") 
    public String login(Model model) {
        return "login"; 
    }

    @PostMapping("/login") 
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD)) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password"); 
            return "login"; 
        }
    }
}