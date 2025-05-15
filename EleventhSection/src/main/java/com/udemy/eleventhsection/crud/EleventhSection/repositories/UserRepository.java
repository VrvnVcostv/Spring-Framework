package com.udemy.eleventhsection.crud.EleventhSection.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eleventhsection.crud.EleventhSection.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
