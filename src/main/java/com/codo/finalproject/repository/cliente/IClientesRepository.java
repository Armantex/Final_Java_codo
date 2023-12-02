package com.codo.finalproject.repository.cliente;


import com.codo.finalproject.entity.Reserva;

import java.util.List;

public interface IClientesRepository {
    List<Reserva> HistorialReservas(int IdUsuario);
}
