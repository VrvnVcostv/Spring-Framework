package com.udemy.fourthsection.error.FourthSection.services;

import java.util.List;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;

public interface UserService {
    User findById(long id);
    List<User> findAll();
}
