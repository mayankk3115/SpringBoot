package com.mySpringProject.learning.learnspringframework.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class MyData {

    public List<Integer> provideData() {
        return Arrays.asList(10,20,79,90,23);
    }
}
