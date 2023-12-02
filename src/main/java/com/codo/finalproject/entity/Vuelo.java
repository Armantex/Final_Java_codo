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
    private Long id;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFinal;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Double precio;
    private String opcionesConexion;

    @OneToOne(mappedBy = "vuelo_boleto")
    private Boleto boleto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aerolinea_vuelo")
    private Aerolinea aerolinea_vuelo;


}
