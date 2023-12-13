package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.response.InformeDiarioDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface IInformeDiarioService {

    public Integer cantidadDeVentasAlDia (LocalDate fecha);
    public Double recaudacionDiaria (LocalDate fecha);
    public InformeDiarioDto getDestinosPopulares(LocalDate fecha);
}
