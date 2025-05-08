package com.udemy.tenthsection.crud.TenthSection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.tenthsection.crud.TenthSection.entities.Product;
import com.udemy.tenthsection.crud.TenthSection.repositories.ProductRepository;

@Service
public class ProductServiceJPA implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> delete(Product product) {
        Optional<Product> delete = repository.findById(product.getId());
        delete.ifPresent(prod ->{
            repository.delete(prod);
        });
        return delete;
    }

}
