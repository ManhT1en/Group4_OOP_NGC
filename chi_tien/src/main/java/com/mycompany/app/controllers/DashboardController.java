package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label welcomeMessage;

    @FXML
    private void handleCourseManagement() throws IOException {
        System.out.println("Navigating to Course Management");
        Main.loadView("course_view"); // Đảm bảo course_view.fxml đã tồn tại
    }
    
    @FXML
    private void handleStudentManagement() throws IOException {
        System.out.println("Navigating to Student Management");
        Main.loadView("student_view"); // Đảm bảo student_view.fxml đã tồn tại
    }

    @FXML
    private void handleLogout() throws IOException {
        System.out.println("Logging out");
        Main.loadView("login_view"); // Quay lại màn hình đăng nhập
    }
    
    
    @FXML
    private void handleGoToCourse(ActionEvent event) throws IOException {
        Main.loadView("course_view"); // Đảm bảo course_view.fxml đã tồn tại
    }

}
