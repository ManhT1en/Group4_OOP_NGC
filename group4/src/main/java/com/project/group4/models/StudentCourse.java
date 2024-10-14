package com.project.group4.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_courses")
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "grade")
    private Double grade;

    // Constructors
    public StudentCourse() {}

    public StudentCourse(Student student, Course course, Double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
        this.id = new StudentCourseId(student.getId(), course.getId());
    }

    // Getters and setters
    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}

