package com.example.automobilesapi.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        var details = new ExceptionDetails();
        details.setStatus(HttpStatus.NOT_FOUND.value());
        details.setMessage(resourceNotFoundException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
