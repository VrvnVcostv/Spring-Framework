package com.udemy.eleventhsection.crud.EleventhSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eleventhsection.crud.EleventhSection.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByUsername(String username);
}
