package com.udemy.secondsection.di.SecondSection.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.udemy.secondsection.di.SecondSection.models.Product;
import com.udemy.secondsection.di.SecondSection.services.ProductServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImpl productService = new ProductServiceImpl();

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
