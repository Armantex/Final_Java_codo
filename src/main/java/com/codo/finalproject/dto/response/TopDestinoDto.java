package com.codo.finalproject.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopDestinoDto {
    private String destino;
    private Long cantidadReservas;
}
