package za.co.idol.assessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import za.co.idol.assessment.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    // CustomExceptionHandler to handle all the custom exceptions i've created

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleInvestorNotFoundException(UserNotFoundException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("Message", exception.getMessage());
        return map;
    }
}
