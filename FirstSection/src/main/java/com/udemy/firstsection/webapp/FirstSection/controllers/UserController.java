package com.udemy.firstsection.webapp.FirstSection.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.udemy.firstsection.webapp.FirstSection.models.User;

// Here I return views with Thymeleaf
@Controller
public class UserController {

    @GetMapping("/details") // Getting details from a Model. It is used by simplicity.
    public String details(Model model){
        User user = new User("Andrés", "Perez");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
    
    @GetMapping("/list") // Getting details from a ModelMap, it is a Model based on a HashMap. You can manipulate the data like a Map.
    public String list(ModelMap model) {
        model.addAttribute("title", "Users List");
        return "list";
    }    

    @ModelAttribute("users") // Getting users by databinding attributes with ModelAttribute, when it is used, theres no need to assign values on a Map.
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Juan", "Gomez", "juan@gmail.com"),
            new User("Julian", "Álvarez"),
            new User("Ramón", "Caballero", "ramon@gmail.com"),
            new User("María", "Flores")
            );
    }
}
