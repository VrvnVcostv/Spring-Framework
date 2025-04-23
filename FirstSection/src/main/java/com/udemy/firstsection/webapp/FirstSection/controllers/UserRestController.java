package com.udemy.firstsection.webapp.FirstSection.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.firstsection.webapp.FirstSection.models.User;
import com.udemy.firstsection.webapp.FirstSection.models.dto.UserDto;



@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        userDto.setUser("Andrés");
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Gabriel", "Liante");
        User user2 = new User("Gabriel", "Nuñez");
        User user3 = new User("Gabriel", "Perez");
        List<User> users = Arrays.asList(user, user2, user3);
        return users;
    }
}
