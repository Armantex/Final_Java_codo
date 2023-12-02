package com.codo.finalproject.dto.request;

import com.codo.finalproject.entity.Asiento;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaSaveDto {
    List<String> nombresPasajeros;
    LocalDate fechaViaje;
    List<Asiento> AsientosId;
    int detallesContacto;
}
