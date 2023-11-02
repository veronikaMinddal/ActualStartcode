package org.example.exception;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ApiException extends Exception{

    private final int statusCode;
    private final Timestamp timestamp;

    public ApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}