package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCliente;

    @OneToMany(mappedBy = "boletos_usuario")
    private Set<Usuario> usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo_boleto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    Usuario usuario_boleto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asiento_id")
    private Asiento asiento_boleto;
}
