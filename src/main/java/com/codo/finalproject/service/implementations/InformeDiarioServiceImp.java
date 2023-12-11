package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.InformeDto;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IInformeDiarioRepository;
import com.codo.finalproject.service.interfaces.IInformeDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InformeDiarioServiceImp implements IInformeDiarioService {

    private IInformeDiarioRepository informeRepositorio;
    private InformeDto informeDiario;
    private Reserva reserva;

    @Override
    public int cantidadDeVentasAlDia(LocalDate fecha) {
    LocalDate fechaDeVuelo = reserva.getFechaViaje();

        return 2; //solo para que no marque error,
        // hasta que cuente cuantos vuelos fueron al día. ;)
    }



}