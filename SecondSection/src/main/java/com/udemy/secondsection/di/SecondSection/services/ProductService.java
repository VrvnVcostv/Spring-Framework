package com.udemy.secondsection.di.SecondSection.services;

import java.util.List;

import com.udemy.secondsection.di.SecondSection.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
