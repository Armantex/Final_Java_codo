package com.codo.finalproject.dto.response;

import com.codo.finalproject.dto.request.UsuarioDto;
import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class HistorialReservaPorUsuarioDto {
    private LocalDate fechaViaje;
    private Boolean Pagada;
    private UsuarioDto usuario;
    private ComprobanteDto Comprobante;
}
