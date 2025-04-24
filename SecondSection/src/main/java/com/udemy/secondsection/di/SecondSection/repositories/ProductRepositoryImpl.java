package com.udemy.secondsection.di.SecondSection.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.secondsection.di.SecondSection.models.Product;

@Component
public class ProductRepositoryImpl implements ProductRepository{
    
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L,"8GB RAM",300L),
            new Product(2L,"Water",44L),
            new Product(3L,"Beef",89L),
            new Product(4L,"RTX 4090",299L),
            new Product(5L,"Keyboard",500L)
            );
    }

    public List<Product> findAll(){
        return data;
    };
    
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    };
    
    

}
