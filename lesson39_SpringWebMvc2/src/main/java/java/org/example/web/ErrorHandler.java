package java.org.example.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.org.example.exception.NameInBlackListException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NameInBlackListException.class)
    public String errorName() {
        return "error";
    }

}
