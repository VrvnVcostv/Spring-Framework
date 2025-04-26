package com.udemy.secondsection.di.SecondSection.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.secondsection.di.SecondSection.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson(){
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
        } catch (Exception e) {} 
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

}
