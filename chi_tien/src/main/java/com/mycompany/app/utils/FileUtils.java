package com.mycompany.app.utils;

import com.mycompany.app.models.Student;
import com.mycompany.app.models.Course;
import com.mycompany.app.models.Registration;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final String STUDENT_FILE = "students.dat";
    private static final String COURSE_FILE = "courses.dat";
    private static final String REGISTRATION_FILE = "registrations.dat";

    // Save students to file
    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE))) {
            out.writeObject(new ArrayList<>(students));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load students from file
    @SuppressWarnings("unchecked")
    public static List<Student> loadStudents() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(STUDENT_FILE))) {
            return (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save courses to file
    public static void saveCourses(List<Course> courses) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(COURSE_FILE))) {
            out.writeObject(new ArrayList<>(courses));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load courses from file
    @SuppressWarnings("unchecked")
    public static List<Course> loadCourses() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(COURSE_FILE))) {
            return (List<Course>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save registrations to file
    public static void saveRegistrations(List<Registration> registrations) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(REGISTRATION_FILE))) {
            out.writeObject(new ArrayList<>(registrations));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load registrations from file
    @SuppressWarnings("unchecked")
    public static List<Registration> loadRegistrations() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(REGISTRATION_FILE))) {
            return (List<Registration>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
