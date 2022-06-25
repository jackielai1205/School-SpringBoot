package com.example.demo.model;

public class ErrorResponse {

    String message;
    Integer httpStatus;


    public ErrorResponse(CustomException err, Integer httpStatus){
        this.message = err.getMessage();
        this.httpStatus = httpStatus;
    }

    public String getException() {
        return message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
