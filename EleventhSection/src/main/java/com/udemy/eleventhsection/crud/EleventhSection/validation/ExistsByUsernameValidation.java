package com.udemy.eleventhsection.crud.EleventhSection.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.eleventhsection.crud.EleventhSection.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByUsernameValidation implements ConstraintValidator<ItExistsByUsername, String>{

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByUsername(value);
    }

}
