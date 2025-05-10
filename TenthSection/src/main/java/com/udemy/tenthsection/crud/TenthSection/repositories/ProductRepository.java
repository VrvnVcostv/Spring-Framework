package com.udemy.tenthsection.crud.TenthSection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy.tenthsection.crud.TenthSection.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

    boolean existsBySku(String sku);
}
