package com.example.ssm2.mapper;

import com.example.ssm2.po.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    List<Student> findStudentsById(Integer id);
}
