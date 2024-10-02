package com.mycompany.app.controllers;

import java.io.IOException;
import java.util.Map;

import com.mycompany.app.Main; 
import com.mycompany.app.models.FileManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField; 
    @FXML private Label messageLabel;

    private FileManager fileManager;
    private String path = "D:\\OOP\\oop_group4_1_1_24_N02\\chi_tien\\file\\login.txt";

    public LoginController() {
        fileManager = new FileManager(path); 
    }

    
    
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Map<String, String> logins = fileManager.loadLogins();

            if (logins.containsKey(username) && logins.get(username).equals(password)) {
                messageLabel.setText("Login successful!");
                Main.loadView("dashboard_view.fxml");
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error reading login file.");
        }
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Username and password cannot be empty.");
            return;
        }

        try {
            fileManager.saveLogin(username, password);
            messageLabel.setText("User registered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error saving login.");
        }
    }
}
