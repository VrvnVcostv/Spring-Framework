package com.udemy.secondsection.di.SecondSection.repositories;

import java.util.List;

import com.udemy.secondsection.di.SecondSection.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
