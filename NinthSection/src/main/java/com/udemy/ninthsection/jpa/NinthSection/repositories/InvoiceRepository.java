package com.udemy.ninthsection.jpa.NinthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
