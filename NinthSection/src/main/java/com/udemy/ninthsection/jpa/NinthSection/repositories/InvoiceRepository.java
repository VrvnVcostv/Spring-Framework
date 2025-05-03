package com.udemy.ninthsection.jpa.NinthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ninthsection.jpa.NinthSection.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
