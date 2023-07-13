package com.msvc.books.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerAllException(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ModelKeyAutogeneratedException.class)
    public ResponseEntity<ErrorResponse> handlerModelKeyAutogeneratedException(ModelKeyAutogeneratedException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
