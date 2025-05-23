package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamDTO;
import com.udemy.firstsection.webapp.FirstSection.models.dto.ParamMixedDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/request") // Getting a message by sending it on the URL with the RequestParam annotation
    public ParamDTO request(@RequestParam(required = false, defaultValue = "No messages received") String message) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/bar") // Getting multimple fields by sending it on the URL with the RequestParam annotation
    public ParamMixedDTO multipleRequest(@RequestParam String text, @RequestParam Integer code) {
        ParamMixedDTO params = new ParamMixedDTO();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/servlet") // Getting multiple fields regardless of their names. You have to guess or handle dynamically.
    public ParamMixedDTO servlet(HttpServletRequest request ) {
        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        }catch (NumberFormatException e){

        }
        ParamMixedDTO params = new ParamMixedDTO();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }
    
}
