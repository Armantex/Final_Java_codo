package com.codo.finalproject.repository.interfaces;

import com.codo.finalproject.entity.InformeDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformeDiarioRepository extends JpaRepository <InformeDiario, Long>{
}
