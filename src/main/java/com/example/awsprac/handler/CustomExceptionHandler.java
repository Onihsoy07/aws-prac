package com.example.awsprac.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String CusIllegalArgumentException(IllegalArgumentException e) {
        return "IllegalArgumentException 발생 " + e.getMessage();
    }

}
