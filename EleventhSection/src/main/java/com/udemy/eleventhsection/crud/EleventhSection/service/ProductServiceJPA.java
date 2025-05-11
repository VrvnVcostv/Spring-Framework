package com.udemy.eleventhsection.crud.EleventhSection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eleventhsection.crud.EleventhSection.entities.Product;
import com.udemy.eleventhsection.crud.EleventhSection.repositories.ProductRepository;

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
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> update = repository.findById(id);
        if(update.isPresent()){
            Product prod = update.get();
            prod.setName(product.getName());
            prod.setSku(product.getSku());
            prod.setPrice(product.getPrice());
            prod.setDescription(product.getDescription());
            return Optional.of(repository.save(prod));
        }
        return update;
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> delete = repository.findById(id);
        delete.ifPresent(prod ->{
            repository.delete(prod);
        });
        return delete;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }
}
