package com.example.recruitmentproject.errors;

public class IncorrectHeaderException extends RuntimeException {

    public IncorrectHeaderException(String statusText) {
        super(statusText);
    }


}
