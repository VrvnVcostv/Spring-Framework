package com.udemy.eleventhsection.crud.EleventhSection.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eleventhsection.crud.EleventhSection.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);
}
