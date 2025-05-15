package com.udemy.eleventhsection.crud.EleventhSection.service;

import java.util.List;

import com.udemy.eleventhsection.crud.EleventhSection.entities.User;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
