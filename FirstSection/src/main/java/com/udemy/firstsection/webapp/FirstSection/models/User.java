package com.udemy.firstsection.webapp.FirstSection.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;
    private String lastname;
    private String email;
    
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    
}
