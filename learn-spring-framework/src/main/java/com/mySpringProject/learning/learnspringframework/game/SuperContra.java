package com.mySpringProject.learning.learnspringframework.game;

import org.springframework.stereotype.Component;

//@Component
public class SuperContra implements GamingConsole{

    public void up() {
        System.out.println("SuperContra Up");
    }

    public void down() {
        System.out.println("SuperContra Down");
    }

    public void left() {
        System.out.println("SuperContra Left");
    }

    public void right() {
        System.out.println("SuperContra Right");
    }

}
