package com.codo.finalproject.dto.request;

import com.codo.finalproject.entity.Asiento;

import java.time.LocalDate;

import com.codo.finalproject.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {
    LocalDate fechaViaje;
    Boolean Pagada;
    List<PasajeroDto> pasajeros;
    List<Asiento> asientos;
    Usuario usuario;
}
