package com.customerService.repository;

import com.customerService.model.Student;

import java.util.List;

public interface StudentRepository {
    void createStudent(Student student);
    Student getStudentById(Long studentId);
    List<Student> getStudentsByFirstName(String firstName);
}
