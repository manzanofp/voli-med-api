package com.manzanofp.voli.med.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerError400(MethodArgumentNotValidException exception){
        var error = exception.getFieldError();
        return ResponseEntity.badRequest().body(error.stream().map(DataErrorHandler::new).toList());
    }

        private  record DataErrorHandler(String field, String message){

            public DataErrorHandler(FieldError error){
                this(error.getField(), error.getDefaultMessage());
            }
        }
}
