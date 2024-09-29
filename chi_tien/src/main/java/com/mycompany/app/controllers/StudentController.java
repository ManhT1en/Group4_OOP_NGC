package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;
import com.mycompany.app.models.Student;
import com.mycompany.ultis.FileUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML private TextField studentIdField;
    @FXML private TextField studentNameField;
    @FXML private TextField studentGpaField;
    @FXML private ListView<Student> studentListView;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    // Method to add a student
    @FXML
    private void addStudent() {
        String id = studentIdField.getText();
        String name = studentNameField.getText();
        double gpa = Double.parseDouble(studentGpaField.getText());

        Student student = new Student(id, name, gpa);
        studentList.add(student);
        studentListView.setItems(studentList);

        // Clear input fields
        studentIdField.clear();
        studentNameField.clear();
        studentGpaField.clear();
    }

    // Method to load students from file
    @FXML
    private void loadStudents() {
        // Call method from FileUtils to load students from file
        studentList.setAll(FileUtils.loadStudents());
        studentListView.setItems(studentList);
    }

    // Method to save students to file
    @FXML
    private void saveStudents() {
        // Call method from FileUtils to save students to file
        FileUtils.saveStudents(studentList);
    }
    
    // Method to handle going back to the dashboard
    @FXML
    private void handleBackToDashboard() throws IOException {
        Main.loadView("dashboard_view"); // Quay lại dashboard
    }
}
