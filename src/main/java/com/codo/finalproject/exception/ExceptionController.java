package com.codo.finalproject.exception;

import com.codo.finalproject.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoFlightsAvailableException.class)
    public ResponseEntity<?>noHayVuelosDisponibles(NoFlightsAvailableException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<?> personaNotFound(PersonaNotFoundException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ReservaNotFoundException.class)
    public ResponseEntity<?> noSeEncontroReserva(ReservaNotFoundException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoReservasForReporteException.class)
    public ResponseEntity<?> noReservaForReporte(NoReservasForReporteException ex){
        ErrorDto err = new ErrorDto(404,ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}