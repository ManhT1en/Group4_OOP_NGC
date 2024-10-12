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
        
    public void saveStudent(String name, String id, float gpa, List<Course> courses) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chi_tien\\file\\studentManager.txt", true))) {
            StringBuilder coursesData = new StringBuilder();
            for (Course course : courses) {
                coursesData.append(course.getCourseID()).append(",").append(course.getCourseName()).append(";"); // Giả sử bạn có getCourseId() và getCourseName() trong Course
            }
            writer.write(id + "</st>" + name + "</st>" + gpa + "</st>" + coursesData.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<String[]> loadStudents() {
        List<String[]> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("chi_tien\\file\\studentManager.txt"))) {
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

    public void saveCourse(Course course) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("path_to_course_file", true))) {
            writer.write(course.getCourseID() + "</courseId>" + course.getCourseName() + "</courseName>");
            writer.newLine();
        }
    }
    
    public List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("path_to_course_file"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] courseData = line.split("</courseId>");
                if (courseData.length == 2) {
                    String courseId = courseData[0];
                    String courseName = courseData[1];
                    courses.add(new Course(courseId, courseName)); // Tạo đối tượng Course
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
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
            writerData.newLine(); 
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
    public Student findStudentById(String studentId) {
        List<String[]> students = loadStudents();
        for (String[] studentData : students) {
            if (studentData[0].equals(studentId)) {
                return new Student(studentData[1], studentData[0], Double.parseDouble(studentData[2]));
            }
        }
        return null; 
    }
}
