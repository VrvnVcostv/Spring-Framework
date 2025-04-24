package com.udemy.secondsection.di.SecondSection.services;

import java.util.List;
import java.util.stream.Collectors;

import com.udemy.secondsection.di.SecondSection.models.Product;
import com.udemy.secondsection.di.SecondSection.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{

    private ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll(){ // When sending an Object, it its necessary to create a new instance of the product due to immutability principle.
        return productRepositoryImpl.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct = (Product) p.clone(); // To keep this principle of immutabilty I clone the product in a new instance
            newProduct.setPrice(priceTax.longValue());// of the same, and now is when I can modify the price.
            return newProduct;
            
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return productRepositoryImpl.findById(id);
    }
}
