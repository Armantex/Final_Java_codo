package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
