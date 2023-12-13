package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


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
    private Boolean Pagada;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante_reserva;

    @OneToMany(mappedBy = "pasajeros_reserva",cascade = CascadeType.ALL)
    private Set<Pasajero> pasajeros;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario reservas_usuario;

    @OneToMany(mappedBy = "asientos_reserva")
    private Set<Asiento> asientos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo_reserva;

}
