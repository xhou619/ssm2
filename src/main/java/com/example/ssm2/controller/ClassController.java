package com.example.ssm2.controller;

import com.example.ssm2.po.Student;
import com.example.ssm2.service.ClassService;
import com.example.ssm2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/classes")
public class ClassController {

    private final ClassService clsService;

    @Autowired
    public ClassController(ClassService clsService) {
        this.clsService = clsService;
    }

    @GetMapping("/{cid}")
    ResponseEntity<List<Student>> getStudentById(@PathVariable String cid) {
        List<Student> students = clsService.getStudentsById(cid);
        return ResponseEntity.ok(students);
    }
}
