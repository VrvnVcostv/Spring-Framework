package com.udemy.eleventhsection.crud.EleventhSection.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.eleventhsection.crud.EleventhSection.service.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ItExistsDbValidation implements ConstraintValidator<ItExistsDb, String> {

    @Autowired
    private ProductService service;

    @Override
        public boolean isValid(String value, ConstraintValidatorContext context){
            if(service != null){
                return !service.existsBySku(value);
            }
            return true;
        }

}
