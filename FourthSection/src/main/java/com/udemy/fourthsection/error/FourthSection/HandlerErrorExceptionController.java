package com.udemy.fourthsection.error.FourthSection;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.udemy.fourthsection.error.FourthSection.models.Error;

@ControllerAdvice
public class HandlerErrorExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZeroEx(Exception ex){    
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Division by zero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("API REST not found");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> numberFormatEx(Exception ex){
        Map<String, Object> error = new HashMap<>(); 
        error.put("date", new Date());
        error.put("error", "Number not valid");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(error);
    }

}
