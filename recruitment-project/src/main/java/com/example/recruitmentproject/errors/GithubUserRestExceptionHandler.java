package com.example.recruitmentproject.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GithubUserRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GithubUserErrorResponse> handleException(GithubUserNotFoundException exc){
        GithubUserErrorResponse error = new GithubUserErrorResponse();

        error.setStatus(HttpStatus.FORBIDDEN.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GithubUserErrorResponse> handleException(IncorrectHeaderException exc){
        GithubUserErrorResponse error = new GithubUserErrorResponse();

        error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
