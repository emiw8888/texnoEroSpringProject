package com.example.texnoeraspringproject.controller;


import com.example.texnoeraspringproject.model.dto.ResponseModel;
import com.example.texnoeraspringproject.model.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public List<ResponseModel> handle(MethodArgumentNotValidException ex){
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> new ResponseModel(x.getDefaultMessage()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseModel handle(UserNotFoundException ex){
        return new ResponseModel(ex.getMessage());
    }
}
