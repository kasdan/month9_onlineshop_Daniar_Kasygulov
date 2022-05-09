package com.attractor.month9onlineshop.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.util.stream.Collectors.toList;


@ControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<Object> exception(UserAlreadyExistsException existsException){
        return new ResponseEntity<>("User already exists",HttpStatus.FOUND);
    }
    @ExceptionHandler(value = UserEmailAlreadyExistsException.class)
    public ResponseEntity<Object> exception(UserEmailAlreadyExistsException exception){
        return new ResponseEntity<>("User email already exists",HttpStatus.FOUND);
    }
}
