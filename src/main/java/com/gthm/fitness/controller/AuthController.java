package com.gthm.fitness.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sign-in")
public class AuthController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Login Successful");
    }
}
