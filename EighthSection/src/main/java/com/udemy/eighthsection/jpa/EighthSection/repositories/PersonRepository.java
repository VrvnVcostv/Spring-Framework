package com.udemy.eighthsection.jpa.EighthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eighthsection.jpa.EighthSection.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    
}
