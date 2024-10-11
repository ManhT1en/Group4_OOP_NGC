package com.project.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.group4.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGpaGreaterThanEqual(double gpa);
}
