package com.first.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldController {

    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String hellowWorld(){
        return "Hello World";
    } 
}
 