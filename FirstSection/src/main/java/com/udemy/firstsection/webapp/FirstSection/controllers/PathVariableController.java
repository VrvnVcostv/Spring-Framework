package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

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
    
}
