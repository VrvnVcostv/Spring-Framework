package com.udemy.seventhsection.aop.SeventhSection.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.udemy.seventhsection.aop.SeventhSection.services.GreetingService;

@Controller
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("greeting")
    public ResponseEntity<?> greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepe", "Hi how are you")));
    
    }
    
    @GetMapping("greetingError")
    public ResponseEntity<?> greetingError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Pepe", "Hi how are you")));
    }

}
