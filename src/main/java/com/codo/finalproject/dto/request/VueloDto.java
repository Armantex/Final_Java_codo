package com.codo.finalproject.dto.request;


import com.codo.finalproject.entity.Aerolinea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class VueloDto {

    //Response User Story 1 Mapping("/getAll/VuelosDisp")

    private Long id;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFinal;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Double precio;
    private String aerolinea;
    private Boolean isFull;
    private short espacioDisponible;

    @Override
    public String toString() {
        return "VueloDto{" +
                "Vuelo N°: " + id +
                ", Fecha de salida: " + horarioInicio +
                ", Fecha de llegada: " + horarioFinal +
                ", Aeropuerto de Origen: '" + aeropuertoOrigen + '\'' +
                ", Aeropuerto Destino: '" + aeropuertoDestino + '\'' +
                ", Precio (Ars):" + precio +
                ", Aerolinea:'" + aerolinea + '\'' +
                '}';
    }
}
