package com.udemy.tenthsection.crud.TenthSection.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.tenthsection.crud.TenthSection.entities.Product;
import com.udemy.tenthsection.crud.TenthSection.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("path")
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        Product newProduct = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Product productId = new Product();
        productId.setId(id);
        Optional<Product> productOptional = service.delete(productId);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
