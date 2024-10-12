package com.project.group4.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Khóa chính tự động tăng
    private Long id;

    @Column(name = "course_id", nullable = false, unique = true)
    private String courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>(); // Liên kết nhiều-nhiều với Student

    // Constructor mặc định
    public Course() {
    }

    // Constructor với tham số
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getCourses().add(this); // Cập nhật mối quan hệ ở cả hai phía
    }

    @Override
    public String toString() {
        return "Course{" +
               "id=" + id +
               ", courseId='" + courseId + '\'' +
               ", courseName='" + courseName + '\'' +
               '}';
    }
}
