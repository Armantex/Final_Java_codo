package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVueloRepository extends JpaRepository<Vuelo,Long> {
}
