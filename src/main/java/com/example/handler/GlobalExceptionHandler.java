package com.example.handler;

import com.example.dtos.ErrorResponse;
import com.example.exceptions.BookingIdFoundException;
import com.example.exceptions.CannotReportIncidentException;
import com.example.exceptions.IdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException argumentNotValidException) {
        Map<String, String> responses = new HashMap<>();

        argumentNotValidException.getBindingResult().getAllErrors().forEach(
                error -> {
                    String fieldError = ((FieldError)error).getField();
                    String msg = error.getDefaultMessage();
                    responses.put(fieldError, msg);
                }
        );

        return new ResponseEntity<>(responses, BAD_REQUEST);
    }

    @ExceptionHandler(CannotReportIncidentException.class)
    public ResponseEntity<ErrorResponse> handleException(CannotReportIncidentException cannotReportIncidentException) {
        return new ResponseEntity<>(new ErrorResponse(cannotReportIncidentException.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(BookingIdFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(BookingIdFoundException bookingIdFoundException) {
        return new ResponseEntity<>(new ErrorResponse(bookingIdFoundException.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(IdNotFoundException idNotFoundException) {
        return new ResponseEntity<>(new ErrorResponse(idNotFoundException.getMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleException(NullPointerException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), NOT_FOUND);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleException(RuntimeException exception){
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), INTERNAL_SERVER_ERROR);

    }
}
