package com.nicholas.phonebook.controller;

import com.nicholas.phonebook.model.ResponseType;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionController {

    @ExceptionHandler
    public ResponseEntity<ResponseType> foundContactException(DataIntegrityViolationException ex) {
        ResponseType error = new ResponseType();
        error.setCode(HttpStatus.FOUND.value());
        error.setMessage("Duplicate contact found");
        return new ResponseEntity<>(error, HttpStatus.FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseType> handleConstraintViolationException(MethodArgumentNotValidException e) {
        List errors = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        String message = String.join(",", errors);
        if(message == null) {
            message = HttpStatus.BAD_REQUEST.getReasonPhrase();
        }
        ResponseType error = new ResponseType();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(message);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

