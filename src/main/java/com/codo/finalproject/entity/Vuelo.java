package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFinal;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Double precio;
    private String opcionesConexion;
    private Boolean isFull;
    private short espacioDisponible;
    private String aerolinea;


    @OneToMany(mappedBy = "asientos_vuelo")
    private Set<Asiento> asientos;

    @OneToMany(mappedBy = "reservas_vuelo")
    private Set<Reserva> reservas;


}
