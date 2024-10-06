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
import java.util.ArrayList;
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
        
     // Lưu sinh viên vào file
    public void saveStudent(String name, String id, float gpa) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("oop_group4_1_1_24_N02\\chi_tien\\file\\studentManager.txt", true))) {
            writer.write(id + "</st>" + name + "</st>" + gpa + "</st>");
            writer.newLine(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tải danh sách sinh viên từ file
    public List<String[]> loadStudents() {
        List<String[]> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("oop_group4_1_1_24_N02\\chi_tien\\file\\studentManager.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split("</st>");
                if (studentData.length == 3) {
                    students.add(studentData); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students; 
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

    public void iDataLogin(String username, String password) throws IOException {
        try (BufferedWriter writerData = new BufferedWriter(new FileWriter(this.getFilePath(), true))) {
            writerData.write(username + "</id>" + password + "</pass>");
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
                result.append(line).append("</pass>"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
    
}
