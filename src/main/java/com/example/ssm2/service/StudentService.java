package com.example.ssm2.service;

import com.example.ssm2.mapper.StudentMapper;
import com.example.ssm2.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student findStudentById(String id) {
        return this.studentMapper.findStudentById(Integer.parseInt(id));
    }

    public Student findStudentById2(String id) {
        return this.studentMapper.findStudentById2(Integer.parseInt(id));
    }
}
