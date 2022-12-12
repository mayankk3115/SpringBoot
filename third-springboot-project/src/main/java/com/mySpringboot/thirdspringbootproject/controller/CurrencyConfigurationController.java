package com.mySpringboot.thirdspringbootproject.controller;

import com.mySpringboot.thirdspringbootproject.CurrencyServiceConfiguration;
import com.mySpringboot.thirdspringbootproject.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration config;

    @RequestMapping("/configuration")
    public CurrencyServiceConfiguration retrieveConfig() {
        return config;
    }

}
