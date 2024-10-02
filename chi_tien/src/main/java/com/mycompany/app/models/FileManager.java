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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }


    public void saveLogin(String username, String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(username + "<sDT>" + password + "</login>");
            writer.newLine(); 
        }
    }

    public Map<String, String> loadLogins() throws IOException {
        Map<String, String> logins = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":"); 
                if (parts.length == 2) {
                    logins.put(parts[0], parts[1]);
                }
            }
        }
        return logins;
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

    public void iDataLogin(String name, String password){
        try {
            FileWriter writerData = new FileWriter(this.getFilePath());
            writerData.write(name + ":" + password);
            writerData.close();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public void oDataLogin(){
        try {
            BufferedReader readData = new BufferedReader(new FileReader(this.getFilePath()));
            String line;
            while((line = readData.readLine()) != null){
                System.out.println(line);
            }
            readData.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
