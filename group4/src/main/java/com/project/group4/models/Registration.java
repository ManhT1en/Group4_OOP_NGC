package com.project.group4.models;

public class Registration {
    private final Student student;
    private final Course course;
    private double score;

    // Constructor
    public Registration(Student student, Course course, double score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    // Getter methods
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getScore() {
        return score;
    }

    // Setter methods
    public void setScore(double score) {
        this.score = score;

    }

    @Override
    public String toString() {
        return "Registration{" +
               "student=" + student +
               ", course=" + course +
               ", score=" + score +
               '}';
    }
}
