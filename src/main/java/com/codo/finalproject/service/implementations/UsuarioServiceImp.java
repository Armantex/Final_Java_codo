package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.interfaces.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
@Service
public class UsuarioServiceImp implements IUsuarioService {
    private IReservaRepository reservaRepository;
    private final ObjectMapper mapper;
    public UsuarioServiceImp(IReservaRepository reservaRepository){
        this.reservaRepository = reservaRepository;
        mapper = new ObjectMapper();
    }

    @Override
    public ResponseDto crearReserva(ReservaDto reserva) {
        Reserva reservaEntity = mapper.convertValue(reserva, Reserva.class);
        reservaRepository.save(reservaEntity);
        return new ResponseDto("La reserva se guardo correctamente.");
    }

    @Override
    public ResponseDto Pagar() {
        return null;
    }

}
