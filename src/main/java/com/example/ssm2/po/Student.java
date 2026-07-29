package com.example.ssm2.po;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private char sex;
    private StudentID sid;
}
