package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.response.ResponseDto;


public interface IUsuarioService {
    ResponseDto crearReserva(ReservaDto reserva);
    ResponseDto Pagar(); // falta saber que le pongo de argumento
}
