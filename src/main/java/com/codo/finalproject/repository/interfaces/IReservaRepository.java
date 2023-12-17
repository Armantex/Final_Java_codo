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

    List<Reserva> findAllByUsuarioId(Long idUsuario);

    @Query(value = "SELECT vuelo_reserva.aeropuertoDestino, COUNT(vuelo_reserva.aeropuertoDestino) AS destinationCount " +
            "FROM Reserva " +
            "WHERE reservas_usuario_id = :userId " +
            "GROUP BY vuelo_reserva.aeropuertoDestino " +
            "ORDER BY destinationCount DESC " +
            "LIMIT 3", nativeQuery = true)
    List<Object[]> findTopDestinationsByUserId(@Param("userId") Long userId);

}

