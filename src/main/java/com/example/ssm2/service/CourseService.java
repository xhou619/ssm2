package com.example.ssm2.service;

import com.example.ssm2.mapper.CourseMapper;
import com.example.ssm2.po.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public Course getCourseById(String id) {
        return this.courseMapper.findCourseWithStudents(Integer.parseInt(id));
    }
}
