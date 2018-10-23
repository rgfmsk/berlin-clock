package com.protel.emre.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ExceptionHandler Class for Illegal inputs
 */
@ControllerAdvice
public class ArgumentExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Prints the exception message if Illegal Argument Found
     *
     * @param ex      thrown Exception
     * @param request Get Request
     * @return ResponseEntity for displaying error message in response
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
}