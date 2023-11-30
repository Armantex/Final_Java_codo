package com.codo.finalproject.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    Boleto Pasajeros;
    LocalDate fechaViaje;
    List<Asiento> preferenciasAsientos;
    int detallesContacto;
}
