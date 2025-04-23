package com.udemy.firstsection.webapp.FirstSection.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.udemy.firstsection.webapp.FirstSection.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Andrés", "Perez");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
    
    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(
            new User("Juan", "Gomez", "juan@gmail.com"),
            new User("Julian", "Álvarez"),
            new User("Ramón", "Caballero", "ramon@gmail.com"),
            new User("María", "Flores")
            ); 
        model.addAttribute("users", users);
        model.addAttribute("title", "Users List");
        return "list";
    }    
}
