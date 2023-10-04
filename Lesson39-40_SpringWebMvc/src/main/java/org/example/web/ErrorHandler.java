package org.example.web;

import org.example.exception.NameInBlackListException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NameInBlackListException.class)
    public String errorName() {
        return "error";
    }

}
