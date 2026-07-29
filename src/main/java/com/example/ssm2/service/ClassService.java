package com.example.ssm2.service;

import com.example.ssm2.mapper.ClassMapper;
import com.example.ssm2.mapper.StudentMapper;
import com.example.ssm2.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassMapper clsMapper;

    @Autowired
    public ClassService(ClassMapper clsMapper) {
        this.clsMapper = clsMapper;
    }

    public List<Student> getStudentsById(String id) {
        return this.clsMapper.findStudentsById(Integer.parseInt(id));
    }
}
