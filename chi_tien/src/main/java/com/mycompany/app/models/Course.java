package com.mycompany.app.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseID;
    private String courseName;
    private List<Student> student;

    public Course() {
    }

    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.student = new ArrayList<>();
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void addStudent(Student student) {
        this.student.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
               "courseId='" + courseID + '\'' +
               ", courseName='" + courseName + '\'' +
               '}';
    }

}