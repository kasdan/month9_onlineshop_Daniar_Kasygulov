package com.attractor.month9onlineshop.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ApplicationExceptionController {
//    private final MessageSource messageSource;

    @ExceptionHandler(value = UserNotFoundException.class)
    public String exceptionUserNotFound(UserNotFoundException exception) {
        return "userNotFound";
    }
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public String exceptionUserExists(UserAlreadyExistsException exception){
        return "userAlreadyExists";
    }
    @ExceptionHandler(value = UserEmailAlreadyExistsException.class)
    public String exceptionUserEmailExists(UserEmailAlreadyExistsException exception){
        return "emailAlreadyExists";
    }

    @ExceptionHandler(value = ClothesNotFountException.class)
    public ResponseEntity<Object> exceptionClothesNotFount(ClothesNotFountException exception){
        return new ResponseEntity<>("Clothes by this id does not exists",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CaptchaDoesNotMatchExeption.class)
    public String exceptionCaptchaDoesNotMatch(CaptchaDoesNotMatchExeption exception){
        return "captchaDoesNotMatch";
    }


//    String localizeErrorMessage(String errorCode) {
//        var locale = LocaleContextHolder.getLocale();
//        return messageSource.getMessage(errorCode, null, locale);
////        getResourceBundle().getMessage("exception.npe", null, Locale.getDefault());
//    }
}
