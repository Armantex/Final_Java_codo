package com.codo.finalproject.serviceTest;

import com.codo.finalproject.entity.Vuelo;
import com.codo.finalproject.exception.NoFlightsAvailableException;
import com.codo.finalproject.repository.interfaces.IVueloRepository;
import com.codo.finalproject.service.implementations.VueloServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VueloServiceTestConMock {

    @Mock
    IVueloRepository repository;

    @InjectMocks
    VueloServiceImpl service;

    /*@Test
    void getVuelosThrowsNoflightAvailableException(){
        //arrange
        List<Vuelo> empty = new ArrayList<>();
        when(repository.findByNotEmpty()).thenReturn(empty);
        //act and assert
        assertThrows(NoFlightsAvailableException.class, ()->service.buscarDisponibles());
    }*/
}
