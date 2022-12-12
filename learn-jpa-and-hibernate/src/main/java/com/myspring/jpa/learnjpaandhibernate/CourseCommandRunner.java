package com.myspring.jpa.learnjpaandhibernate;

import com.myspring.jpa.learnjpaandhibernate.Model.Course;
import com.myspring.jpa.learnjpaandhibernate.Repository.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommandRunner implements CommandLineRunner {

//    @Autowired
//    private courseRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn Docker", "In28min"));
        repository.save(new Course(2,"Learn Kubernetes", "Kodekloud"));
        repository.save(new Course(3,"LearnSpring and Springboot", "In28min"));
        repository.deleteById(2l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(3l));
        System.out.println("#########################");
        System.out.println(repository.findAll());
        System.out.println("=================================");
        System.out.println(repository.findByAuthor("In28min"));
        System.out.println("------------------------------------");
        System.out.println(repository.findByName("Learn Docker"));
        System.out.println("******************");
        System.out.println(repository.count());

    }
}
