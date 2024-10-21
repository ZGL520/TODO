package com.todo.ztodo.controller;
import com.todo.ztodo.utils.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(CommonException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}