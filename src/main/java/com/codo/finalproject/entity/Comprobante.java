package com.codo.finalproject.entity;

import com.codo.finalproject.util.MetodoPago;
import jakarta.persistence.*;
import lombok.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MetodoPago metodoPago;
    private Double monto;
    @Column(unique = true)
    private Integer codigoComprobante;

    @OneToOne(mappedBy = "comprobante_reserva")
    private Reserva reserva;


}
