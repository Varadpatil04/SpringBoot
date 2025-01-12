package com.example.myApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public void debug(){
        System.out.println("Debugging .....");
    }
    public void compile(){
        System.out.println("Compiled !!");
    }
}
