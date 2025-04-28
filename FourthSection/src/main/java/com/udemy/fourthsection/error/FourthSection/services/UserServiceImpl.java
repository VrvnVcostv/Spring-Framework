package com.udemy.fourthsection.error.FourthSection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(long id) {
        return users.stream().filter(usr -> usr.getId() == id).findFirst();
    }

    
}
