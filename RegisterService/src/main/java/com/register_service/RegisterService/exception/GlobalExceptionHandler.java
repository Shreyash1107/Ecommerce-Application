package com.register_service.RegisterService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<List<String>> handleValidation(ResourceNotFoundException resourceException){
       return new ResponseEntity<>(List.of(resourceException.getMessage()), HttpStatus.NOT_FOUND);
    }
}