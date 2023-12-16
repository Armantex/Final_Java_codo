package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.response.InformeDiarioDto;

import java.time.LocalDate;


public interface IInformeDiarioService {

    public InformeDiarioDto generarInformeDiario(LocalDate fecha);
}
