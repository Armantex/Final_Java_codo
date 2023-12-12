package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findByUsuarioId(Long idUsuario);

}
