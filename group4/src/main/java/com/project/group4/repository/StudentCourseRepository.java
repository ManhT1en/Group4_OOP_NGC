package com.project.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.group4.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    StudentCourse findByStudentIdAndCourseId(Long studentId, Long courseId);
    List<StudentCourse> findByCourseId(Long courseId);
    List<StudentCourse> findByStudentId(Long studentId);
}