package com.example.exceptions;

public class CannotReportIncidentException extends RuntimeException{
    public CannotReportIncidentException(String message){
        super(message);
    }
}
