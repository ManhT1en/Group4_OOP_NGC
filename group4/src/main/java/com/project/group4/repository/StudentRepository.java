package com.project.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.group4.models.Course;
import com.project.group4.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGpaGreaterThanEqual(Double gpa); // cần giải thích 

    @Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long studentId);
}
