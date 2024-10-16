package com.project.group4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.group4.models.Course;
import com.project.group4.models.Student;
import com.project.group4.models.StudentCourse;
import com.project.group4.repository.StudentCourseRepository;
import com.project.group4.repository.StudentRepository;
import com.project.group4.repository.CourseRepository;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public StudentCourse registerCourse(Long studentId, Long courseId) {
        // Tìm student và course theo ID
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        
        return studentCourseRepository.save(studentCourse);
    }

    public void registerStudentForCourse(Student student, Course course) {
        StudentCourse studentCourse = new StudentCourse(student, course);
        studentCourseRepository.save(studentCourse);
    }

    public boolean isStudentRegisteredForCourse(Student student, Course course) {
        return studentCourseRepository.findByStudentAndCourse(student, course) != null;
    }
}