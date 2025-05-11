package com.udemy.eleventhsection.crud.EleventhSection.validation;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.udemy.eleventhsection.crud.EleventhSection.entities.Product;

@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "it's required!");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.product.description");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", null, "it's required!");
        }
        if(product.getPrice() == null){
            errors.rejectValue("price", null, "it's required!");
        }else if(product.getPrice() < 100){
            errors.rejectValue("price", null, "must be greater than 100!");
        }
        
    }


}
