package com.udemy.fourthsection.error.FourthSection.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;
import com.udemy.fourthsection.error.FourthSection.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/app")
public class AppController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        // int value = 100/0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User getUsers(@PathVariable String id) {
        return userService.findById(Long.valueOf(id));
    }
    
}
