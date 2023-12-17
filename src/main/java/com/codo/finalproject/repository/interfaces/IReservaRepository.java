package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {

    List<Reserva> getReservasByPagadaIsTrueAndFechaViajeEquals(LocalDate fecha);

    @Query(value = "SELECT * FROM reserva WHERE comprobante_id=?",nativeQuery = true)
    Reserva findByIdComprobante(Long idComprobante);
}
