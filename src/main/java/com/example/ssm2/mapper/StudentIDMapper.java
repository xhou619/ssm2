package com.example.ssm2.mapper;

import com.example.ssm2.po.StudentID;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentIDMapper {
    StudentID findCodeById(Integer id);
}
