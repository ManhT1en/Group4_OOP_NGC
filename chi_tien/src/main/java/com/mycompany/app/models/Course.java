package com.mycompany.app.models;

import java.util.List;
import java.util.Map;

public class Course {
    private String courseID;
    private String courseName;
    private List<Student> student;
    private Map<Student, Double> score;

    public Course() {
    }

    public Course(String courseID, String courseName, List<Student> student, Map<Student, Double> score) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.student = student;
        this.score = score;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public Map<Student, Double> getScore() {
        return score;
    }
    
    public void setScore(Map<Student, Double> score) {
        this.score = score;
    }

    public List<Student> getStudent() {
        return student; // Trả về danh sách sinh viên của môn học này
    }
    
    
}
