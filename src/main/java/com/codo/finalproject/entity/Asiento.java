package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nroAsiento;
    private Boolean Disponibilidad;

    @OneToMany(mappedBy = "asientos_reserva")
    private Set<Reserva> reservas;

    @OneToOne(mappedBy = "asiento_boleto")
    private Boleto boleto;
}
