package com.codo.finalproject.service.usuario;

import com.codo.finalproject.dto.request.ReservaSaveDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.codo.finalproject.repository.usuario.IUsuarioRepository;
import com.codo.finalproject.repository.usuario.UsuarioRepositoryImp;
import com.codo.finalproject.exception.InsertionDBException;
@Service
public class UsuarioServiceImp implements IUsuarioService {
    private IUsuarioRepository repository;
    private final ObjectMapper mapper;
    public UsuarioServiceImp(UsuarioRepositoryImp repository){
        this.repository = repository;
        mapper = new ObjectMapper();
    }

    @Override
    public ResponseDto crearReserva(ReservaSaveDto reserva) {
        Reserva reservaEntity = mapper.convertValue(reserva, Reserva.class);
        Reserva respuestaRepo =  repository.saveReserva(reservaEntity);
        if(respuestaRepo == null){
            throw new InsertionDBException("Falla durante la insersion.");
        }
        return new ResponseDto("La reserva se guardo correctamente.");
    }

    @Override
    public ResponseDto Pagar() {
        return null;
    }
}
