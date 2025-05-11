package com.udemy.eleventhsection.crud.EleventhSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.eleventhsection.crud.EleventhSection.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

    boolean existsBySku(String sku);
}
