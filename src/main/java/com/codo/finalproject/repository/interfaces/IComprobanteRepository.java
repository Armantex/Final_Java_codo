package com.codo.finalproject.repository.interfaces;


import com.codo.finalproject.entity.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IComprobanteRepository extends JpaRepository<Comprobante,Long> {
    @Query(value = "SELECT * FROM comprobante WHERE codigo_comprobante=?",nativeQuery = true)
    Comprobante findByCodigoComprobante(int codigoComprobante);

}
