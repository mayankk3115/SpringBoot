package com.mySpringboot.thirdspringbootproject.controller;

import com.mySpringboot.thirdspringbootproject.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourse() {
        return Arrays.asList(
                new Course(1, "Learn Aws!", "In28min"),
                new Course(2, "Learn Docker!", "KodeKloud"),
                new Course(3, "Learn Hibernate!", "In28min"),
                new Course(4, "Learn Terraform!", "kodekloud")
        );
    }

}
