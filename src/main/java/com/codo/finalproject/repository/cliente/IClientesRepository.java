package com.codo.finalproject.repository.cliente;


public interface IClientesRepository {
    List<Reserva> HistorialReservas(int IdUsuario);
}
