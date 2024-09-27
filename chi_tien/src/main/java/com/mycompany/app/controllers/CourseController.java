package com.mycompany.app.controllers;

import com.mycompany.app.models.Course;
import com.mycompany.ultis.FileUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CourseController {

    @FXML private TextField courseIdField;
    @FXML private TextField courseNameField;
    @FXML private ListView<Course> courseListView;

    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    // Method to add a course
    @FXML
    private void addCourse() {
        String courseId = courseIdField.getText();
        String courseName = courseNameField.getText();

        Course course = new Course(courseId, courseName);
        courseList.add(course);
        courseListView.setItems(courseList);

        // Clear input fields
        courseIdField.clear();
        courseNameField.clear();
    }

    // Method to load courses from file
    @FXML
    private void loadCourses() {
        // Call method from FileUtils to load courses from file
        courseList.setAll(FileUtils.loadCourses());
        courseListView.setItems(courseList);
    }

    // Method to save courses to file
    @FXML
    private void saveCourses() {
        // Call method from FileUtils to save courses to file
        FileUtils.saveCourses(courseList);
    }
}
