package com.codo.finalproject.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class InformeDiarioDto {
    private Integer cantidadDeVentasDelDia;
    private Double ingresos;
    private LocalDate fecha;
}
