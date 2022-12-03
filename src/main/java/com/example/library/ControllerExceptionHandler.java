package com.example.library;

import com.example.library.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFound(NotFoundException e) {
        return "404";
    }

    @ExceptionHandler(Exception.class)
    public String handleNotFound(Exception e) {
        return "error";
    }
}
