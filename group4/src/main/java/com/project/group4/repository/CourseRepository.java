package com.project.group4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.group4.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}