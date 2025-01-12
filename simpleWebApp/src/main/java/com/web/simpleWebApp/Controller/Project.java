package com.web.simpleWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Project {

    @RequestMapping("/project")
    public String project(){
        return "Hey These are my projects";
    }
}
