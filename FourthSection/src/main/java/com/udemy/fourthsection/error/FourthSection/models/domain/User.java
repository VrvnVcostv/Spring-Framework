package com.udemy.fourthsection.error.FourthSection.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String lastname;

    private Role role;

    public User(long id, String name, String lastname){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public String getRole(){
        return role.getName();
    }
}
