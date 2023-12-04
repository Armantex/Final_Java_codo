package com.codo.finalproject.entity;

import com.codo.finalproject.util.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer telefono;
    private String domicilio;
    private String email;
    private Rol rol;


    @OneToOne(mappedBy = "usuario_reserva")
    private Reserva reserva;

    @OneToOne(mappedBy = "usuario_cliente")
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario_boleto")
    private Boleto boleto;
}
