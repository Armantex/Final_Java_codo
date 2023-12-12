package com.codo.finalproject.service.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface IInformeDiarioService {

    public Integer cantidadDeVentasAlDia (LocalDate fecha);
    public Double recaudacionDiaria (LocalDate fecha);
}
