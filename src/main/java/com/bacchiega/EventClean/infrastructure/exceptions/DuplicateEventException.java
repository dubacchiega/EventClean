package com.bacchiega.EventClean.infrastructure.exceptions;

public class DuplicateEventException extends RuntimeException{
    public DuplicateEventException(String message) {
        super(message);
    }
}
