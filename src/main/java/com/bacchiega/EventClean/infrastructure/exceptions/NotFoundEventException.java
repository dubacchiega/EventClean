package com.bacchiega.EventClean.infrastructure.exceptions;

public class NotFoundEventException extends RuntimeException{

    public NotFoundEventException(String message) {
        super(message);
    }
}
