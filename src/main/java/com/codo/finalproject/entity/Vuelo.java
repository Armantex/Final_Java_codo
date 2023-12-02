package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vueloId;

    private LocalDateTime horarioInicio;

    private LocalDateTime horarioFinal;

    private String aeropuertoOrigen;

    private String aeropuertoDestino;

    private Double precio;

    @OneToOne
    @JoinColumn(name = "aerolineaId")
    private Aerolinea aerolinea;

    private String opcionesConexion;
}
