package com.example.myApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{
    public void debug(){
        System.out.println("Debugging in desktop.....");
    }
    public void compile(){
        System.out.println("Compiled in desktop!!");
    }
}
