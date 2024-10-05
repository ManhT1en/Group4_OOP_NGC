package com.mycompany.app.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    private String studentFilePath = "oop_group4_1_1_24_N02\\chi_tien\\file\\studentManager.txt"; // Đường dẫn đến file lưu sinh viên

    // Phương thức lưu thông tin sinh viên vào file với ký tự ngắt </st>
    public void saveStudent(String name, String id, float gpa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentFilePath, true))) {
            writer.write(id + "</st>" + name + "</st>" + gpa + "</st>");
            writer.newLine(); // Thêm dòng mới sau mỗi sinh viên
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để đọc danh sách sinh viên từ file
    public List<String[]> loadStudents() {
        List<String[]> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(studentFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Tách dữ liệu dựa trên ký tự ngắt </st>
                String[] studentData = line.split("</st>");
                if (studentData.length == 3) {
                    students.add(studentData); // Đảm bảo có đúng 3 trường: ID, Name, GPA
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students; // Trả về danh sách sinh viên
    }

    public void clearStudentsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentFilePath))) {
            // Xóa toàn bộ nội dung file
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
