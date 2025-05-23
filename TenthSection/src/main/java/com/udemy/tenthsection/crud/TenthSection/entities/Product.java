package com.udemy.tenthsection.crud.TenthSection.entities;

import com.udemy.tenthsection.crud.TenthSection.Validation.IsRequired;
import com.udemy.tenthsection.crud.TenthSection.Validation.ItExistsDb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ItExistsDb
    @IsRequired
    private String sku;
    
    @IsRequired
    @Size(min=3, max=20)
    private String name;
    @Min(message = "{Min.product.price}", value =  100)
    @NotNull
    private Integer price;
    @IsRequired
    private String description;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }

    
}
