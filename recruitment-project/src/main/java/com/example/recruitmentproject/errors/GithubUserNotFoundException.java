package com.example.recruitmentproject.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class GithubUserNotFoundException extends RuntimeException {

    public GithubUserNotFoundException( String statusText) {
        super(statusText);
    }


}
