package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.User;
import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
    
    @Value("#{'${config.listOfValues}'.toUpperCase.split(',')}")
    private List<String> valueList;
    
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;
    
    @Value("#{${config.valueMap}}")
    private Map<String, Object> valueMap;
    
    @Value("#{${config.valueMap}.product}")
    private String product;
    
    @Value("#{${config.valueMap}.description}")
    private String description;
    
    @Value("#{${config.valueMap}.price}")
    private Integer price;

    @Autowired
    private Environment enviroment;

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
        Long code2 = enviroment.getProperty("config.code", Long.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.username);
        map.put("code", this.code);
        map.put("message", message);
        map.put("message2", enviroment.getProperty("config.message"));
        map.put("code2", code2);
        map.put("list", this.list);
        map.put("valueList", this.valueList);
        map.put("valueString", this.valueString);
        map.put("valueMap", this.valueMap);
        map.put("product", this.product);
        map.put("description", this.description);
        map.put("price", this.price);

        return map;
    }
    
}
