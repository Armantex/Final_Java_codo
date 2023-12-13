package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {

    List<Reserva> getReservasByPagadaIsTrueAndFechaViajeEquals(LocalDate fecha);
}
