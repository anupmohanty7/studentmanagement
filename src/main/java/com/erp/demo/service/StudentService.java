package com.erp.demo.service;

import java.util.List;

import com.erp.demo.model.Student;


public interface StudentService {
	List<Student> getAllStudents();

    Student getStudentById(int id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> searchStudentByName(String name);
}
