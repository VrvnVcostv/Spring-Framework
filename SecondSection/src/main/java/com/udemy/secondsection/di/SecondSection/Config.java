package com.udemy.secondsection.di.SecondSection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.udemy.secondsection.di.SecondSection.repositories.ProductRepository;
import com.udemy.secondsection.di.SecondSection.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties")
})
public class Config {

    @Value("classpath:json/product.json")
    private Resource resource; 

    @Bean
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(resource);
    }
}
