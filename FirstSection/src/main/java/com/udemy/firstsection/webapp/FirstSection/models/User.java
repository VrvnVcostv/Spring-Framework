package com.udemy.firstsection.webapp.FirstSection.models;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String lastname;
    private String email;
    
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    
}
