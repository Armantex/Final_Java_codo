package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boletoId;
    private String nombreCliente;
    private Enum fromaDePago;
    private Long idVuelo;
    private Long idUsuario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asientoId")
    private Asiento asiento;
}
