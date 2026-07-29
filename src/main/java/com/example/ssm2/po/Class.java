package com.example.ssm2.po;

import lombok.Data;

import java.util.List;

@Data
public class Class {
    private Integer id;
    private String name;
    private List<Student> students;
}
