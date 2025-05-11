package com.udemy.eleventhsection.crud.EleventhSection.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ItExistsDbValidation.class)
public @interface ItExistsDb {
    String message() default "already exists on the data base (decorator)";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
