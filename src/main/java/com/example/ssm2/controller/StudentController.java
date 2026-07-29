package com.example.ssm2.controller;

import com.example.ssm2.po.Student;
import com.example.ssm2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }
}
