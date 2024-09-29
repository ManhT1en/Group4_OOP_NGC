package com.mycompany.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label welcomeMessage;

    @FXML
    private void handleCourseManagement() {
        System.out.println("Navigating to Course Management");
        // Code to navigate to course management view
    }

    @FXML
    private void handleStudentManagement() {
        System.out.println("Navigating to Student Management");
        // Code to navigate to student management view
    }

    @FXML
    private void handleLogout() {
        System.out.println("Logging out");
        // Code to navigate back to login screen
    }
}
