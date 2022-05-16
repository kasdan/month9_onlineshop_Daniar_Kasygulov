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
    public ResponseEntity<Object> exceptionUserNotFound(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<Object> exceptionUserExists(UserAlreadyExistsException existsException){
        return new ResponseEntity<>("User already exists",HttpStatus.FOUND);
    }
    @ExceptionHandler(value = UserEmailAlreadyExistsException.class)
    public ResponseEntity<Object> exceptionUserEmailExists(UserEmailAlreadyExistsException exception){
        return new ResponseEntity<>("User email already exists",HttpStatus.FOUND);
    }

    @ExceptionHandler(value = ClothesNotFountException.class)
    public ResponseEntity<Object> exceptionClothesNotFount(ClothesNotFountException exception){
        return new ResponseEntity<>("Clothes by this id does not exists",HttpStatus.NOT_FOUND);
    }
}
