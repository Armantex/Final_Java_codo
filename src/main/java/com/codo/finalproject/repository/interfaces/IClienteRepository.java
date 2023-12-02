package com.codo.finalproject.repository.interfaces;
import com.codo.finalproject.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
