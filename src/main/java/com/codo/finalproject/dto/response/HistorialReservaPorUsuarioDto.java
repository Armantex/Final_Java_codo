package com.codo.finalproject.dto.response;

import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistorialReservaPorUsuarioDto {
    LocalDate fechaViaje;
    Boolean Pagada;
    Usuario usuario;
    Comprobante Comprobante;

}
