package com.mycompany.app.controllers;

import java.io.IOException;

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
    private String path = "oop_group4_1_1_24_N02\\chi_tien\\file\\login.txt"; // Đường dẫn đến file login.txt

    public LoginController() {
        fileManager = new FileManager(path); 
    }

    @FXML
    private void handleLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
    
        String dataLogin = fileManager.oDataLogin(); 
        String[] dataParts = dataLogin.split("</pass>");
        
        boolean isLoggedIn = false;
        for (String dataPart : dataParts) {
            String[] userInfo = dataPart.split("</id>");
            if (userInfo.length == 2) {
                String storedUsername = userInfo[0];
                String storedPassword = userInfo[1];
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    isLoggedIn = true;
                    break;
                }
            }
        }
    
        if (isLoggedIn) {
            messageLabel.setText("Login successful!");
            Main.loadView("dashboard_view"); 
        } else {
            messageLabel.setText("Invalid username or password.");
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
            fileManager.iDataLogin(username, password);
            messageLabel.setText("User registered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error saving login.");
        }
    }
}
