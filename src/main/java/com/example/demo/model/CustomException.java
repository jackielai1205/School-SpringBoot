package com.example.demo.model;

public class CustomException extends Exception{

    private Exception exception;
    private Integer httpStatus;

    public CustomException(Exception exception, Integer httpStatus) {
        super(exception);
        this.exception = exception;
        this.httpStatus = httpStatus;
    }

    public Exception getException() {
        return exception;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
