package com.mycompany.app.controllers;

import java.io.IOException;
import java.util.List;

import com.mycompany.app.Main;
import com.mycompany.app.models.Course;
import com.mycompany.app.models.Student;
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
        String courseID = courseIdField.getText();
        String courseName = courseNameField.getText();

        Course course = new Course(courseID, courseName);
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

    // Method to handle going back to the dashboard
    @FXML
    private void handleBackToDashboard() {
        try {
            Main.loadView("dashboard_view"); // Quay lại dashboard
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
    }

    @FXML
    private void showStudentsInSelectedCourse() {
        String selectedCourse = courseListView.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            String[] courseData = selectedCourse.split("</cid>");
            String courseId = courseData[0]; // Lấy ID khóa học từ danh sách

            // Tìm khóa học trong danh sách
            for (Course course : courseList) {
                if (course.getCourseID().equals(courseId)) {
                    List<Student> enrolledStudents = course.getStudent(); // Lấy danh sách sinh viên đã đăng ký
                    // Hiển thị danh sách sinh viên
                    for (Student student : enrolledStudents) {
                        System.out.println("Student: " + student.getName()); // In ra danh sách sinh viên
                    }
                    break;
                }
            }
        }
    }
}
