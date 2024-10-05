package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;

import javafx.fxml.FXML;

public class DashboardController {

    @FXML
    private void handleStudentManagement() throws IOException {
        Main.loadView("student_view"); // Đảm bảo file FXML của "Student Management" là student_view.fxml
    }

    @FXML
    private void handleCourseManagement() throws IOException {
        Main.loadView("course_view"); // Tương tự cho Course Management
    }

    @FXML
    private void handleLogout() throws IOException {
        Main.loadView("login_view"); // Quay lại trang login khi logout
    }
}
