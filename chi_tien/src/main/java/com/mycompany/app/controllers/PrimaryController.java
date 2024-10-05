package com.mycompany.app.controllers;

import java.io.IOException;
import com.mycompany.app.Main;
import javafx.fxml.FXML;

public class PrimaryController {

    // Chuyển sang giao diện quản lý sinh viên
    @FXML
    private void goToStudent() throws IOException {
        Main.setRoot("student_view");
    }

    // Chuyển sang giao diện quản lý khóa học
    @FXML
    private void goToCourse() throws IOException {
        Main.setRoot("course_view");
    }

    // Chuyển sang giao diện quản lý đăng ký
    @FXML
    private void goToRegistration() throws IOException {
        Main.setRoot("registration_view");
    }
}