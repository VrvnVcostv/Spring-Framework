package com.udemy.fourthsection.error.FourthSection;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> getUsers(){
        User u1 = new User(1L, "Paco", "Fiestas");
        User u2 = new User(2L, "Samuel", "Guzmán");
        User u3 = new User(3L, "Iván", "López");
        User u4 = new User(4L, "María", "Caballero");
        User u5 = new User(5L, "María", "Gutierrez");
        return Arrays.asList(u1, u2, u3, u4, u5);
    }
}
