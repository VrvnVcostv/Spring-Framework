package com.udemy.fifthsection.interceptor.FifthSection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/foo")
    public Map<String, String> foo() {
        
        
        
        return Collections.singletonMap("message", "handler Foo from controller");
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {
        
        
        
        return Collections.singletonMap("message", "handler Bar from controller");
    }

    @GetMapping("/baz")
    public Map<String, String> baz() {
        
        
        
        return Collections.singletonMap("message", "handler Baz from controller");
    }
    
}
