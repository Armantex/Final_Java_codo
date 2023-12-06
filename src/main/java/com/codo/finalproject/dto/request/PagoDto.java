package com.codo.finalproject.dto.request;

import com.codo.finalproject.util.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagoDto {
    private MetodoPago metodoPago;
    private Double monto;
    private Integer codigoComprobante;

}
