package com.flight.api.exception.handler;

import com.flight.api.exception.ApiError;
import com.flight.api.exception.DateFormatException;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(status, "Bad request body", path);
        return new ResponseEntity<>(apiError, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        String field = ((FieldError) ex.getBindingResult().getAllErrors().get(0)).getField();
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(status, field + ": " + message, path);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("eh");
        return super.handleServletRequestBindingException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(status, "missing parameter", path);
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
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), path);
        return new ResponseEntity<>(apiError,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        List<ConstraintViolation<?>> list = ex.getConstraintViolations().stream().toList();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,list.get(0).getMessageTemplate(), path);
        return new ResponseEntity<>(apiError,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
