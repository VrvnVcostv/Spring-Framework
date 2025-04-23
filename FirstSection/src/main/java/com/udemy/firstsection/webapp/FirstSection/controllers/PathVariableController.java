package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.User;
import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    // @Value("${config.message}")
    // private String message;
    @Value("${config.code}")
    private Long code;
    @Value("${config.listOfValues}")
    private List<String> list;
    
    @GetMapping("/onePath/{message}")
    public ParamDTO onePath(@PathVariable String message) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mixedPath/{product}/{id}")
    public Map<String, Object> mixedPath(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        
        json.put("product", product);
        json.put("id", id);

        return json;
    }
    
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> getValues(@Value("${config.message}") String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.username);
        map.put("message", message);
        map.put("code", this.code);
        map.put("list", this.list);

        return map;
    }
    
}
