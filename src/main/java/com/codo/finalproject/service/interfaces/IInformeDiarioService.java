package com.codo.finalproject.service.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface IInformeDiarioService {

    public int cantidadDeVentasAlDia (LocalDate fecha);
    public double recaudacionDiaria (LocalDate fecha);
}
