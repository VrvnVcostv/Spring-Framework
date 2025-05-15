package com.udemy.eleventhsection.crud.EleventhSection.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.eleventhsection.crud.EleventhSection.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ItExistsByUsername, String>{

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(service != null){
                return !service.existsByUsername(value);
            }
            return true;
    }

}
