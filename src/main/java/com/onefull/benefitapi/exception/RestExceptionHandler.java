package com.onefull.benefitapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.onefull.benefitapi.model.ErrorModel;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage());

        return new ResponseEntity<ErrorModel>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    private ResponseEntity<ErrorModel> handleEmptyResultDataAccess(EmptyResultDataAccessException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", "No existe el dato que intenta borrar");

        return new ResponseEntity<ErrorModel>(error, HttpStatus.NOT_FOUND);
    }
}