package com.myspring.jpa.learnjpaandhibernate.Repository;

import com.myspring.jpa.learnjpaandhibernate.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);

}
