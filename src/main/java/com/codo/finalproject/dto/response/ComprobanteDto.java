package com.codo.finalproject.dto.response;

import com.codo.finalproject.util.MetodoPago;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComprobanteDto {
    private Long id;
    private MetodoPago metodoPago;
    private Double monto;
    private Integer codigoComprobante;
}
