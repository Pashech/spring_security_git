package com.example.spring_security.controller;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/user")
    public String user(Authentication authentication){
        System.out.println(authentication.getPrincipal());
        return "User";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }
}
