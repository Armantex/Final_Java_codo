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
    private String formaDePago;
    private Long idVuelo;
    private Long idUsuario;

    @OneToMany(mappedBy = "boletos_cliente")
    private Set<Cliente> cliente;

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
