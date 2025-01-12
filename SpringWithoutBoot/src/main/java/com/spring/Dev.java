package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Dev {

    private int age;
    private Computer com;

    public Computer getCom() {
        return com;
    }
    public void setCom(Computer com) {
        this.com = com;
    }

    public Dev(Computer com) {
        this.com = com;
    }

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public Dev(int age) {
        this.age = age;
        System.out.println("In const Dev 1");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dev(){
        System.out.println("In dev const");
    }
    public void build(){
        com.debug();
        System.out.println("Wroking.....!!!");
    }
}
