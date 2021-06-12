package com.ecommerce.colab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHanler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleusernameException(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<Object>(new GenricExceptionFormat(new Date(),"Sorry No user with this name",ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<Object>(new GenricExceptionFormat(new Date(),"Sorry Something went wrong",ex.getMessage()), HttpStatus.BAD_GATEWAY);
    }
}
