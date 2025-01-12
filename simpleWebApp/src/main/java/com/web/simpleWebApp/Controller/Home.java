package com.web.simpleWebApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Home {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to home Page ❤️";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is my about page";
    }
}
