package com.mycompany.app.controllers;

import java.io.IOException;

import com.mycompany.app.Main;
import com.mycompany.app.models.studentDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML private TextField studentIdField;
    @FXML private TextField studentNameField;
    @FXML private TextField studentGpaField;
    @FXML private TextField filterGpaField; 
    @FXML private ListView<String> studentListView;

    private ObservableList<String> studentList = FXCollections.observableArrayList();
    private studentDAO studentDAO = new studentDAO(); 

    @FXML
    private void addStudent() {
        String id = studentIdField.getText();
        String name = studentNameField.getText();
        double gpa = Double.parseDouble(studentGpaField.getText());

        studentDAO.saveStudent(name, id, (float) gpa);

        String studentInfo = "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
        studentList.add(studentInfo);
        studentListView.setItems(studentList);

        studentIdField.clear();
        studentNameField.clear();
        studentGpaField.clear();
    }

    @FXML
    private void loadStudents() {
        studentList.clear(); 

        for (String[] studentData : studentDAO.loadStudents()) {
            String studentInfo = "ID: " + studentData[0] + ", Name: " + studentData[1] + ", GPA: " + studentData[2];
            studentList.add(studentInfo); 
        }

        studentListView.setItems(studentList);
    }

    @FXML
    private void filterStudents() {
        double filterGpa = Double.parseDouble(filterGpaField.getText()); 
        ObservableList<String> filteredList = FXCollections.observableArrayList();

        for (String studentInfo : studentList) {
            String[] studentData = studentInfo.split(", ");
            double gpa = Double.parseDouble(studentData[2].split(": ")[1]); 
            if (gpa >= filterGpa) { 
                filteredList.add(studentInfo); 
            }
        }

        studentListView.setItems(filteredList);
    }

    // Phương thức xóa sinh viên đã chọn
    @FXML
    private void deleteStudent() {
        String selectedStudent = studentListView.getSelectionModel().getSelectedItem(); // Lấy sinh viên đã chọn

        if (selectedStudent != null) {
            // Xóa sinh viên khỏi danh sách
            studentList.remove(selectedStudent);
            studentListView.setItems(studentList);

            // Cập nhật file lưu sinh viên
            updateStudentFile();
        }
    }

    // Phương thức để cập nhật lại file lưu sinh viên sau khi xóa
    private void updateStudentFile() {
        // Đọc toàn bộ sinh viên trong danh sách và lưu vào file
        studentDAO.clearStudentsFile(); // Phương thức xóa file (xem thêm bên dưới)
        for (String studentInfo : studentList) {
            String[] parts = studentInfo.split(", ");
            String id = parts[0].split(": ")[1];
            String name = parts[1].split(": ")[1];
            double gpa = Double.parseDouble(parts[2].split(": ")[1]);
            studentDAO.saveStudent(name, id, (float) gpa);
        }
    }

    @FXML
    private void handleBackToDashboard() throws IOException {
        Main.loadView("dashboard_view"); 
    }
}
