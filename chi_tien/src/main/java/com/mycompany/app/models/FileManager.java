package com.mycompany.app.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {
    private String filePath;

    // Constructor
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    // Save students to file
    public void saveStudent(List<Student> student) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(student);
        }
    }

    // Load students from file
    public List<Student> loadStudent() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Student>) in.readObject();
        }
    }

    // Save courses to file
    public void saveCourses(List<Course> courses) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(courses);
        }
    }

    // Load courses from file
    public List<Course> loadCourses() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Course>) in.readObject();
        }
    }

    // Save registrations to file
    public void saveRegistrations(List<Registration> registrations) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(registrations);
        }
    }

    // Load registrations from file
    public List<Registration> loadRegistrations() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Registration>) in.readObject();
        }
    }
}