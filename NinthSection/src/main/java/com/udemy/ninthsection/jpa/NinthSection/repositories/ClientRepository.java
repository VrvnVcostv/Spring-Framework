package com.udemy.ninthsection.jpa.NinthSection.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udemy.ninthsection.jpa.NinthSection.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("select c from Client c left join fetch c.addresses where c.id=?1")
    Optional<Client> findOneAddresses(Long id);

    @Query("select c from Client c left join fetch c.invoices where c.id=?1")
    Optional<Client> findOneInvoices(Long id);

    @Query("select c from Client c left join fetch c.invoices left join fetch c.addresses where c.id=?1")
    Optional<Client> findOne(Long id);
}
