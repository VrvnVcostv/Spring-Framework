package com.udemy.secondsection.di.SecondSection.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.secondsection.di.SecondSection.models.Product;


public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson(Resource resource){
        //Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource){
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
        return list.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }

}
