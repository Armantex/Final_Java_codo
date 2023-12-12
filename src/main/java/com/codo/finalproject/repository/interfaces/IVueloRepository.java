package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVueloRepository extends JpaRepository<Vuelo,Long> {
    //List<Vuelo>FindByisFullFalse();

    @Query(value = "SELECT * FROM flysky.vuelo WHERE is_full = 0",nativeQuery = true)
    List<Vuelo>findByNotEmpty();


}
