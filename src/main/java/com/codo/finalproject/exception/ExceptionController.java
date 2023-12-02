package com.codo.finalproject.exception;

import com.codo.finalproject.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<?> personaNotFound(PersonaNotFoundException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsertionDBException.class)
    public ResponseEntity<?> personaNotFound(InsertionDBException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClonException.class)
    public ResponseEntity<?> personaNotFound(ClonException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}