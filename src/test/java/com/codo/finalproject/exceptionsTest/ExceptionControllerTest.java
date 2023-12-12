package com.codo.finalproject.exceptionsTest;

import com.codo.finalproject.dto.response.ErrorDto;
import com.codo.finalproject.exception.ExceptionController;
import com.codo.finalproject.exception.NoFlightsAvailableException;
import com.codo.finalproject.exception.PersonaNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionControllerTest {

    @Autowired
    ExceptionController exceptionController;

    @Test
    void noHayVuelosDisponiblesOkTest(){
        //arrange
        ErrorDto body = new ErrorDto(404,"Test Msg");
        NoFlightsAvailableException argumentoSut = new NoFlightsAvailableException("Test Msg");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //act
        ResponseEntity<?> actual = exceptionController.noHayVuelosDisponibles(argumentoSut);
        //assert
        assertEquals(expected,actual);
    }
}
