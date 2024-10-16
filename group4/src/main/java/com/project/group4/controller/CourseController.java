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
import com.project.group4.models.StudentCourse;
import com.project.group4.repository.CourseRepository;
import com.project.group4.repository.StudentCourseRepository;
import com.project.group4.repository.StudentRepository;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String showCourses(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);  // Thêm đối tượng courses vào model
        return "courseManage";  // Trả về view courseManage.html
    }

    // Hiển thị form thêm điểm cho sinh viên trong một khóa học cụ thể
    @GetMapping("/{courseId}/students")
    public String showStudentsInCourse(@PathVariable Long courseId, Model model) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        
        // Lấy danh sách các bản ghi sinh viên trong khóa học
        List<StudentCourse> studentCourses = studentCourseRepository.findByCourseId(courseId);
        
        // Lấy danh sách sinh viên từ các bản ghi sinh viên-khóa học
        List<Student> students = studentCourses.stream().map(StudentCourse::getStudent).toList();
        
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        model.addAttribute("studentCourses", studentCourses); // Thêm danh sách StudentCourse vào model

        return "addGrade"; // Trả về view để hiển thị danh sách sinh viên
    }

    @PostMapping("/{courseId}/students/{studentId}/add-grade")
    public String addGradeForStudent(@PathVariable Long courseId, @PathVariable Long studentId, @RequestParam Double grade) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        
        // Cập nhật điểm cho sinh viên trong khóa học
        StudentCourse studentCourse = studentCourseRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (studentCourse == null) {
            throw new RuntimeException("StudentCourse not found");
        }
        studentCourse.setGrade(grade);
        studentCourseRepository.save(studentCourse);

        return "redirect:/courses/" + courseId + "/students";
    }
}