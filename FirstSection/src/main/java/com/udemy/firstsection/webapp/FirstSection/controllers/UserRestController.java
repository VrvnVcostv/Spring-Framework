package com.udemy.firstsection.webapp.FirstSection.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.User;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        userDto.setUser("Andrés");
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;
        // User user = new User("Andrés", "Perez");
        // Map<String, Object> response = new HashMap<>();
        // response.put("title", "Hola Mundo Spring Boot");
        // response.put("user", user);
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Gabriel", "Liante");
        User user2 = new User("Gabriel", "Nuñez");
        User user3 = new User("Gabriel", "Perez");
        
        List<User> users = Arrays.asList(user, user2, user3);

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;
    }
}
