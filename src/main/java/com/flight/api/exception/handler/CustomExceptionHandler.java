package com.flight.api.exception.handler;

import com.flight.api.exception.ApiError;
import com.flight.api.model.Flight;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.NoSuchElementException;

@EnableWebMvc
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(status, "endpoint not found", path);
        return new ResponseEntity<>(apiError, headers, status);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNoSuchElementExceptionException(NoSuchElementException ex, WebRequest request){
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(), path);
        return new ResponseEntity<>(apiError,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex, WebRequest request){
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(), path);
        return new ResponseEntity<>(apiError,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
