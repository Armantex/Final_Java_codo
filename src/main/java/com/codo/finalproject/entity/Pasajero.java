package com.codo.finalproject.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva pasajeros_reserva;

}
