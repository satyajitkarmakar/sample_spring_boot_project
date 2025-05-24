package com.example.exceptions;

public class BookingIdFoundException extends RuntimeException{
    public BookingIdFoundException(String message){
        super(message);
    }
}
