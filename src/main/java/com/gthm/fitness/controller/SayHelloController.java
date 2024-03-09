package com.gthm.fitness.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SayHelloController {
    @GetMapping
    public String sayHello(){
        return "hello";
    }
}
