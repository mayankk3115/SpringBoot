package com.mySpringProject.learning.learnspringframework.enterprise;

import com.mySpringProject.learning.learnspringframework.business.MyBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MywebController {
    @Autowired
    private MyBusiness myBusiness;
    public Optional<Integer> returnValueFromBusinessValue() {
        return myBusiness.sumOfData();
    }
}
