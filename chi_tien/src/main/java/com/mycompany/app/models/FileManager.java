package com.mycompany.app.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {
    private String filePath;

    private FileManager(){};

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void saveLogin(String username, String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(username + "</id>" + password + "</pass>");
            writer.newLine(); 
        }
    }
        
    public void saveStudent(List<Student> students) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(students);
        }
    }

    public List<Student> loadStudent() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Student>) in.readObject();
        }
    }

    public void saveCourses(List<Course> courses) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(courses);
        }
    }

    public List<Course> loadCourses() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Course>) in.readObject();
        }
    }

    public void saveRegistrations(List<Registration> registrations) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(registrations);
        }
    }

    public List<Registration> loadRegistrations() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Registration>) in.readObject();
        }
    }

    public void iDataLogin(String name, String password) {
        try (BufferedWriter writerData = new BufferedWriter(new FileWriter(this.getFilePath(), true))) {
            writerData.write(name + "</id>" + password + "</pass>");
            writerData.newLine(); // Thêm dòng mới sau mỗi đăng nhập
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String oDataLogin() {
        StringBuilder result = new StringBuilder();
        try (BufferedReader readData = new BufferedReader(new FileReader(this.getFilePath()))) {
            String line;
            while ((line = readData.readLine()) != null) {
                result.append(line).append("</pass>"); // Thêm dấu phân cách
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
}
