package com.mycompany.app.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private double gpa;
    private List<Course> courses;

    public Student(){}

    public Student(String name, String id, double gpa){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    @Override
    public String toString() {
        return "Student{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", gpa=" + gpa +
               '}';
    }
}