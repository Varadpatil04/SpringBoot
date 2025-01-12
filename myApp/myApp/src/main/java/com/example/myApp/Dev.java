package com.example.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    // Feild Injection
    @Autowired
    @Qualifier("laptop")
    private Computer com;

//    Constrouctor injection
//    public Dev(Laptop lp){
//        this.lp = lp;
//    }

//    Setter method
//    @Autowired
//    public void setlp(Laptop lp){
//        this.lp = lp;
//    }



    public void build(){
        System.out.println();
        System.out.println("Wroking.....!!!");
        com.debug();
        com.compile();
    }
}
