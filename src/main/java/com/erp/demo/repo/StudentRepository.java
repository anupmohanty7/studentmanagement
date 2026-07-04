package com.erp.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>  {
    List<Student> findByNameContainingIgnoreCase(String name);

    long countByGender(String gender);

    @Query("SELECT COUNT(DISTINCT s.course) FROM Student s")
    long countDistinctCourses();
}
