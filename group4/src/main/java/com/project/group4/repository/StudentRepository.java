package com.project.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.group4.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId")
    List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);
    
    @Query("SELECT s FROM Student s JOIN s.courses sc GROUP BY s HAVING AVG(sc.grade) >= :gpa")
    List<Student> findByGpaGreaterThanEqual(@Param("gpa") double gpa);

    @Modifying
    @Transactional
    @Query("UPDATE StudentCourse sc SET sc.grade = :grade WHERE sc.id.studentId = :studentId AND sc.id.courseId = :courseId")
    void updateGrade(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("grade") Double grade);
}