package com.udemy.fourthsection.error.FourthSection.services;

import java.util.List;
import java.util.Optional;

import com.udemy.fourthsection.error.FourthSection.models.domain.User;

public interface UserService {
    Optional<User> findById(long id);
    List<User> findAll();
}
