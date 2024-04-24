package com.demo.employeeDatabase.exceptions;


public class EmailFormatException extends RuntimeException{
    public EmailFormatException(String message) {
        super(message);
    }
}
