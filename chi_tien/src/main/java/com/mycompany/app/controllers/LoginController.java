package com.mycompany.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;

    // Dummy credentials for demo purposes
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            loginMessage.setText("Login successful!");
            // Logic to switch to another scene after successful login
        } else {
            loginMessage.setText("Invalid username or password.");
        }
    }
}