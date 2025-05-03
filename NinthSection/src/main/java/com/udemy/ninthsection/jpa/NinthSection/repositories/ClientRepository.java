package com.udemy.ninthsection.jpa.NinthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
