package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Long> {

    @Query(value = "SELECT * FROM reserva WHERE comprobante_id=?",nativeQuery = true)
    Reserva findByIdComprobante(Long idComprobante);

    @Query(value = "select * FROM reserva where usuario_id = ?",nativeQuery = true)
    List<Reserva> findAllByUsuarioId(Long idUsuario);

}

