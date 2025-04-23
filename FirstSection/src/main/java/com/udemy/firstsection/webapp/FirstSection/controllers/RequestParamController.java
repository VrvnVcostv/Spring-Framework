package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDTO getParam(@RequestParam(required = false, defaultValue = "No messages received") String message) {

        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/bar")
    public ParamDTO getParams(@RequestParam String text, @RequestParam Integer code) {
        ParamDTO params = new ParamDTO();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
}
