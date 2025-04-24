package com.udemy.secondsection.di.SecondSection.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.udemy.secondsection.di.SecondSection.models.Product;


@Repository
public class ProductRepositoryJPA implements ProductRepository{



    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "TV", 100L));
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}
