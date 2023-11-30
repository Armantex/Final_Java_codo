package com.codo.finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{
    /*OneToMany (cascade= CascadeType.ALL)
    @JoinColumn
            (name="fk_idBoleto")*/
    private List<Boleto> listadoDeBoletos;
}
