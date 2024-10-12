package com.project.group4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.group4.models.Course;
import com.project.group4.models.Student;
import com.project.group4.repository.StudentRepository;

@Controller
@RequestMapping("/students") 
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Hiển thị danh sách sinh viên
    @GetMapping
public String showStudents(Model model) {
    List<Student> students = studentRepository.findAll();
    model.addAttribute("students", students);
    return "students"; 
}

    // Thêm sinh viên
    @PostMapping("/add")
    public String addStudent(@RequestParam String name, 
                            @RequestParam String studentId, 
                            @RequestParam double gpa, Model model) {
        // Kiểm tra GPA
        if (gpa < 0.0 || gpa > 4.0) {
            model.addAttribute("error", "GPA must be between 0.0 and 4.0");
            return "students"; // Trả về trang danh sách sinh viên với thông báo lỗi
        }

        Student student = new Student(name, studentId, gpa);
        studentRepository.save(student);
        return "redirect:/students"; 
    }


    // Lọc sinh viên theo GPA
    @GetMapping("/filter")
    public String filterByGpa(@RequestParam double gpa, Model model) {
        List<Student> filteredStudents = studentRepository.findByGpaGreaterThanEqual(gpa);
        model.addAttribute("students", filteredStudents); 
        return "students"; 
    }

    // Xóa sinh viên
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "redirect:/students"; // Redirect về danh sách sinh viên sau khi xóa
        } else {
            // Xử lý khi không tìm thấy sinh viên
            return "redirect:/students?error=notfound"; // Redirect với thông báo lỗi
        }
    }

    @GetMapping("/{id}/courses")
    public String showStudentCourses(@PathVariable Long id, Model model) {
        List<Course> courses = studentRepository.findCoursesByStudentId(id); 
        model.addAttribute("courses", courses);
        return "studentCourses"; // Trả về view để hiển thị môn học
    }
}
