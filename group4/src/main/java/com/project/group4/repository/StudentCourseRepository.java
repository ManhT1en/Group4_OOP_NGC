package com.project.group4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.group4.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    List<StudentCourse> findByCourseId(Long courseId);
    Optional<StudentCourse> findByStudentIdAndCourseId(Long studentId, Long courseId);
}

