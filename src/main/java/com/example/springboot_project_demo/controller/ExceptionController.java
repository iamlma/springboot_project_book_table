package com.example.springboot_project_demo.controller;

import com.example.springboot_project_demo.exception.SecondException;
import com.example.springboot_project_demo.exception.ThirdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/exception/resource")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throwException() {
        throw new SecondException("throwException(): Second Exception");
    }

    @GetMapping("/exception/resource/subresource")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throwThirdException() {
        throw new ThirdException("throwThirdException(): Third Exception");
    }

    @GetMapping("/exception/resource/subresource/anotherresource")
    public void throwAnotherException() {
        throw new SecondException("another exception");
    }

    // new endpoint // throw ThirdException

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
