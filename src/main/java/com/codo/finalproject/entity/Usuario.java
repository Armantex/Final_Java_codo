package com.codo.finalproject.entity;

import com.codo.finalproject.util.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @OneToMany(mappedBy = "reservas_usuario")
    private Set<Reserva> reservas;
}
