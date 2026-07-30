package com.example.ssm2.mapper;

import com.example.ssm2.po.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {
    Course findCourseWithStudents(Integer id);
}
