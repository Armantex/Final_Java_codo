package com.codo.finalproject.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloDto {
    private List<String> nombreDePasajeros;
    private LocalDateTime fechaDeViaje;
    private String preferenciaDeAsiento;
}
