package com.example.ssm2.po;

import lombok.Data;

import java.util.List;

@Data
public class Course {
    private Integer id;
    private String name;
    private String code;
    private List<Student> students;
}
