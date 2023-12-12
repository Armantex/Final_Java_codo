package com.codo.finalproject.dto.response;

import com.codo.finalproject.dto.request.PasajeroDto;
import com.codo.finalproject.entity.Asiento;
import com.codo.finalproject.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class HistorialReservaPorUsuarioDto {
    LocalDate fechaViaje;
    Boolean Pagada;
    Usuario usuario;
    Integer Comprobante;

}
