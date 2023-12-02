package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaViaje;

    @ManyToOne
    @JoinColumn(name = "pasajeros_id")
    private Pasajero pasajeros_reserva;

    @ManyToOne
    @JoinColumn(name = "asientos_id")
    private Asiento asientos_reserva;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_reserva;
}
