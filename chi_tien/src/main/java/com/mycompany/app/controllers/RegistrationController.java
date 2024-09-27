package com.mycompany.app.controllers;

import com.mycompany.app.models.Course;
import com.mycompany.app.models.Registration;
import com.mycompany.app.models.Student;
import com.mycompany.ultis.FileUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML private TextField studentIdField;
    @FXML private TextField courseIdField;
    @FXML private TextField scoreField;
    @FXML private ListView<Registration> registrationListView;

    private ObservableList<Registration> registrationList = FXCollections.observableArrayList();
    private ObservableList<Student> studentList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    // Method to register a student in a course
    @FXML
    private void registerStudent() {
        String studentId = studentIdField.getText();
        String courseId = courseIdField.getText();
        double score = Double.parseDouble(scoreField.getText());

        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            Registration registration = new Registration(student, course, score);
            registrationList.add(registration);
            registrationListView.setItems(registrationList);
        }

        // Clear input fields
        studentIdField.clear();
        courseIdField.clear();
        scoreField.clear();
    }

    // Method to load registrations from file
    @FXML
    private void loadRegistrations() {
        // Call method from FileUtils to load registrations from file
        registrationList.setAll(FileUtils.loadRegistrations());
        registrationListView.setItems(registrationList);
    }

    // Method to save registrations to file
    @FXML
    private void saveRegistrations() {
        // Call method from FileUtils to save registrations to file
        FileUtils.saveRegistrations(registrationList);
    }

    // Utility methods to find a student and course by ID
    private Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseById(String id) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(id)) {
                return course;
            }
        }
        return null;
    }
}
