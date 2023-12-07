package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean Disponibilidad;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva asientos_reserva;

    @ManyToOne
    @JoinColumn(name = "vielo_id")
    private Vuelo asientos_vuelo;

}
