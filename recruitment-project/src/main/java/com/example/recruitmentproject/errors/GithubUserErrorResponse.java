package com.example.recruitmentproject.errors;

public class GithubUserErrorResponse {
    private int status;
    private String message;

    public GithubUserErrorResponse() {
    }

    public GithubUserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
