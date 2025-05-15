package com.udemy.eleventhsection.crud.EleventhSection.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsByUsernameValidation.class)
public @interface ItExistsByUsername {
    String message() default "already exists on the data base (decorator)";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
