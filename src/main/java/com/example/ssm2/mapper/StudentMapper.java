package com.example.ssm2.mapper;

import com.example.ssm2.po.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Student findStudentById(Integer id);

    Student findStudentById2(Integer id);
}
