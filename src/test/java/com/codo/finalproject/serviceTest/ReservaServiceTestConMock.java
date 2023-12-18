package com.codo.finalproject.serviceTest;

import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.entity.Usuario;
import com.codo.finalproject.exception.ReservaNotFoundException;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.repository.interfaces.IUsuarioRepository;
import com.codo.finalproject.service.implementations.ReservaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTestConMock {
    @Mock
    IReservaRepository repository;
    @Mock
    IUsuarioRepository usuarioRepository;

    @InjectMocks
    ReservaServiceImp service;

    @Test
    void getHistorialReservaThrowsReservaNotFoundException(){
        //arrange
        Long usuarioId = 1L;
        List<Reserva> empty = new ArrayList<>();
        when(repository.findAllByUsuarioId(usuarioId)).thenReturn(empty);
        when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.of(new Usuario()));
        //act and assert
        assertThrows(ReservaNotFoundException.class,()->service.getHistorialReserva(usuarioId));
    }
}
