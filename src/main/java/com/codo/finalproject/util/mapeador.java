package com.codo.finalproject.util;

import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.entity.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;

public class mapeador {
    public static ReservaDto entityToDto (Reserva reserva){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(reserva, ReservaDto.class);
    }

    public static Reserva dtoToEntity (ReservaDto reserva){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(reserva, Reserva.class);
    }

}
