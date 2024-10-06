package com.mycompany.app.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.mycompany.app.Main;
import com.mycompany.app.models.FileManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML private TextField studentIdField;
    @FXML private TextField studentNameField;
    @FXML private TextField studentGpaField;
    @FXML private ListView<String> studentListView;
    @FXML private Label messageLabel; 

    private ObservableList<String> studentList = FXCollections.observableArrayList();
    private FileManager fileManager = new FileManager("oop_group4_1_1_24_N02\\chi_tien\\file\\studentManager.txt");

    @FXML
    private void addStudent() {
        String id = studentIdField.getText();
        String name = studentNameField.getText();
        String gpaStr = studentGpaField.getText();
    
        if (id.isEmpty() || name.isEmpty() || gpaStr.isEmpty()) {
            messageLabel.setText("All fields (ID, Name, GPA) must be filled.");
            return; 
        }
    
        float gpa;
    
        try {
            gpa = Float.parseFloat(gpaStr); 
            if (gpa < 0 || gpa > 4) {
                messageLabel.setText("GPA must be between 0 and 4.");
                return; 
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid GPA format. Please enter a valid number.");
            return;
        }
    
        List<String[]> currentStudents = fileManager.loadStudents(); 
        studentList.clear(); 
        for (String[] student : currentStudents) {
            studentList.add(student[0] + "</st>" + student[1] + "</st>" + student[2] + "</st>"); // Thêm sinh viên cũ vào danh sách
        }
    
        String studentData = id + "</st>" + name + "</st>" + gpa + "</st>";
        studentList.add(studentData); 
    
        saveStudents(); 
    
        studentIdField.clear();
        studentNameField.clear();
        studentGpaField.clear();
        messageLabel.setText("Student added successfully!"); 
    }
    
    @FXML
    private void loadStudents() {
        List<String[]> students = fileManager.loadStudents();
        studentList.clear(); 
        for (String[] student : students) {
            studentList.add(student[0] + "</st>" + student[1] + "</st>" + student[2] + "</st>"); // Thêm sinh viên vào danh sách
        }
        studentListView.setItems(studentList); 
    }

    @FXML
    private void deleteStudent() {
        String selectedStudent = studentListView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
            studentListView.setItems(studentList); 
            
            saveStudents(); 
        } else {
            messageLabel.setText("Please select a student to delete.");
        }
    }

    @FXML
    private void filterStudents() {
        String gpaStr = studentGpaField.getText(); 
        double filterGpa;

        try {
            filterGpa = Double.parseDouble(gpaStr);
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid GPA input."); 
            return; 
        }

        ObservableList<String> filteredList = FXCollections.observableArrayList();

        for (String studentInfo : studentList) {
            String[] studentData = studentInfo.split("</st>"); 
            if (studentData.length == 3) { 
                try {
                    double gpa = Double.parseDouble(studentData[2]); 
                    if (gpa >= filterGpa) { 
                        filteredList.add(studentInfo); 
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing GPA for student: " + studentInfo);
                }
            }
        }

        if (filteredList.isEmpty()) {
            messageLabel.setText("No students found with GPA >= " + filterGpa);
        } else {
            messageLabel.setText(""); 
        }

        studentListView.setItems(filteredList); 
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("oop_group4_1_1_24_N02\\chi_tien\\file\\studentManager.txt"))) {
            for (String student : studentList) {
                writer.write(student);
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Error saving students.");
        }
    }

    @FXML
    private void handleBackToDashboard() throws IOException {
        Main.loadView("dashboard_view"); 
    }
}
