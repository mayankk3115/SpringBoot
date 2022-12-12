package com.mySpringProject.learning.learnspringframework.business;

import com.mySpringProject.learning.learnspringframework.data.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyBusiness {

    @Autowired
    private MyData data;

    public Optional<Integer> sumOfData() {
        List<Integer> datas = data.provideData();
        return datas.stream().reduce(Integer::sum);
    }
}
