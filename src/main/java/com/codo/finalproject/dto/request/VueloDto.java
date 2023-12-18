package com.codo.finalproject.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloDto {

    private Long id;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFinal;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Double precio;
    private String aerolinea;
    private Boolean isFull;
    private short espacioDisponible;

}
