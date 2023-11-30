package com.codo.finalproject.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InformeDiarioDto {
    private Integer ventasDelDia;
    private Double ingresos;
    private String DestinoPopular;
}
