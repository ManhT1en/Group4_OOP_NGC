package com.project.group4.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id", unique = true, nullable = false)
    private String courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @Column(name = "grade") // Điểm mà sinh viên nhận được cho môn học này
    private Double grade;

    public Course() {}

    public Course(String courseId, String courseName, Double grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
