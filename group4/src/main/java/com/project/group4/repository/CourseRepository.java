package com.project.group4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.group4.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
