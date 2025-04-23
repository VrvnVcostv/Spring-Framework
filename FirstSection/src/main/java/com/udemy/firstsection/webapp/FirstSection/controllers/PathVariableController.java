package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/bar")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDTO baz(@PathVariable String message) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }
    
}
