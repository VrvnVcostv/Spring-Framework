package com.udemy.fourthsection.error.FourthSection.models.domain;


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

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
