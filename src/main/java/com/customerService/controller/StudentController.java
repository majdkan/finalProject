package com.customerService.controller;

import com.customerService.model.Student;
import com.customerService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "student/create")
    public void createStudent(@RequestBody Student student){
        studentRepository.createStudent(student);
    }

    @GetMapping(value = "student/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentRepository.getStudentById(studentId);
    }
}
