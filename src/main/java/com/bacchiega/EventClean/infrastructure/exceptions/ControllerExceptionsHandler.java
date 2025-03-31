package com.bacchiega.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String,String>> handleDuplicateEventException(DuplicateEventException e) {
        Map<String,String> response = new HashMap<>();
        response.put("Error:", e.getMessage());
        response.put("Message:", "Please, insert a valid hashId for your event and try again.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleIdentifierNotFoundException(NotFoundEventException e){
        Map<String, String> response = new HashMap<>();
        response.put("Error:", e.getMessage());
        response.put("Message:", "Event not found with that identifier.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
