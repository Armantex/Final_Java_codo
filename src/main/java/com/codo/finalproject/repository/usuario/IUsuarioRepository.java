package com.codo.finalproject.repository.usuario;

import com.codo.finalproject.entity.Reserva;

public interface IUsuarioRepository {
    Reserva saveReserva(Reserva reserva);
}
