package com.myRestApi.restApi.controller;

import com.myRestApi.restApi.configuration.HelloWorldBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping("/")
//    public String printHelloWorld() {
//        return "Hello From Rest Api";
//    }

    @RequestMapping("/hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello From Rest Api");
    }

    //Path variables
    @RequestMapping("/hello-bean/{name}")
    public HelloWorldBean helloWorldBeanWithPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello From Rest Api"+ "  " +name);
    }

    //Multiple path variables
    @RequestMapping("/hello-bean/{name}/message/{message}")
    public HelloWorldBean helloWorldBeanWithMultiplePathVariable(
            @PathVariable String name,@PathVariable String message) {
        return new HelloWorldBean("Hello From Rest Api"+ "  " +name+ " "+ message);
    }
}
