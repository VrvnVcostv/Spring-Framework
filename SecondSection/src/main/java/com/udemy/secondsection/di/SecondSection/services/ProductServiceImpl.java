package com.udemy.secondsection.di.SecondSection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.udemy.secondsection.di.SecondSection.models.Product;
import com.udemy.secondsection.di.SecondSection.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    @Qualifier("productRepositoryJson") // This annotation it's used to select wich one of the 2 interfaces implementation do you want to use
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;
    // public ProductServiceImpl(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    @SuppressWarnings("null")
    @Override
    public List<Product> findAll(){ // When sending an Object, it its necessary to create a new instance of the product due to immutability principle.
        return productRepository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Product newProduct = (Product) p.clone(); // To keep this principle of immutabilty I clone the product in a new instance
            newProduct.setPrice(priceTax.longValue());// of the same, and now is when I can modify the price.
            return newProduct;
            //p.setPrice(priceTax.longValue());
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return productRepository.findById(id);
    }
}
