package com.codo.finalproject.repository;


public interface IClientesRepository {
    List<Reserva> HistorialReservas(int IdUsuario);
}
