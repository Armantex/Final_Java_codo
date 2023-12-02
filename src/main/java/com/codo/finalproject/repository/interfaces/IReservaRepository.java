package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva,Long> {
}
