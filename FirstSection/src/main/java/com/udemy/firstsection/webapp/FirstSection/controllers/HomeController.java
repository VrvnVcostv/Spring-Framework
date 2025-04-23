package com.udemy.firstsection.webapp.FirstSection.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping({"","/","/home"}) 
    public String home() {
        return "forward:/details";  // Redirecting URL paths. But it doesn't refreshes the page or sends another HTTP request
        // return "redirect:/details"; // Redirecting URL paths. It refreshes the page and sends another HTTP request.
    }
    
}
