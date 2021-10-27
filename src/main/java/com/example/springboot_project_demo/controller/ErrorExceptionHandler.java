package com.example.springboot_project_demo.controller;

import com.example.springboot_project_demo.exception.SecondException;
import com.example.springboot_project_demo.exception.ThirdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SecondException.class)
    public Error handleSecondException(final SecondException secondException) {
        return new Error(secondException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ThirdException.class)
    public Error handleThirdException(final ThirdException thirdException) {
        return new Error(thirdException.getMessage());
    }
}
