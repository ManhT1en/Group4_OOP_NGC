package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label loginMessage;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            loginMessage.setText("Login successful!");
            try {
                // Chuyển sang giao diện Dashboard sau khi đăng nhập thành công
                Main.loadView("dashboard_view");
            } catch (IOException e) {
                e.printStackTrace();
                loginMessage.setText("Failed to load user dashboard.");
            }
        } else {
            loginMessage.setText("Invalid username or password.");
        }
    }
}
