package com.codo.finalproject.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La persona no fue encontrada.")
public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(String message) {
        super(message);
    }
}
