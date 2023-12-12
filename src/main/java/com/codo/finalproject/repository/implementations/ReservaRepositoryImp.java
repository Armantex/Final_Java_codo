package com.codo.finalproject.repository.implementations;

import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IReservaRepository;

import java.util.List;

public class ReservaRepositoryImp implements IReservaRepository {

    @Override
    public List<Reserva> findByUser(int id) {
        return dataBase.stream()
                .filter(reserva -> reserva.getId()>=id)
                .toList();
    }
}
