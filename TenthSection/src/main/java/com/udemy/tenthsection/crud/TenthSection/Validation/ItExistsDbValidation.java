package com.udemy.tenthsection.crud.TenthSection.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.tenthsection.crud.TenthSection.services.ProductService;

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
