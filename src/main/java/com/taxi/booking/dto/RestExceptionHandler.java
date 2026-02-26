package com.taxi.booking.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParam(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        String msg = String.format("400 Bad Request: Required parameter '%s' is not present.", name);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

}
