package com.udemy.fourthsection.error.FourthSection.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();
        this.users.add(new User(1L, "Paco", "Fiestas"));
        this.users.add(new User(2L, "Samuel", "Guzmán"));
        this.users.add(new User(3L, "Iván", "López"));
        this.users.add(new User(4L, "María", "Caballero"));
        this.users.add(new User(5L, "María", "Gutierrez"));
    }

    @Override
    public Optional<User> findById(long id) {
        User newUser = null;
        for (User user : users) {
            if (user.getId() == id) {
                newUser = user;
                break;
            }
        }
        return Optional.ofNullable(newUser);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
