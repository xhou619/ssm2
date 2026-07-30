package com.example.ssm2.controller;

import com.example.ssm2.po.Course;
import com.example.ssm2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{cid}")
    ResponseEntity<Course> getCourseById(@PathVariable String cid) {
        Course course = courseService.getCourseById(cid);
        return ResponseEntity.ok(course);
    }
}
