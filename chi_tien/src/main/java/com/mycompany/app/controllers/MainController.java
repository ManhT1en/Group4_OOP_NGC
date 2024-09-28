package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;

import javafx.fxml.FXML;

public class MainController {

    @FXML private void handleStudentManagement() {
        try {
            // Chuyển sang màn hình quản lý sinh viên
            Main.setRoot("student_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleCourseManagement() {
        try {
            // Chuyển sang màn hình quản lý khóa học
            Main.setRoot("course_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleRegistrationManagement() {
        try {
            // Chuyển sang màn hình quản lý đăng ký
            Main.setRoot("registration_view");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
