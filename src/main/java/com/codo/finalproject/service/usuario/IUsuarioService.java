package com.codo.finalproject.service.usuario;

import com.codo.finalproject.dto.request.ReservaSaveDto;
import com.codo.finalproject.dto.response.ResponseDto;


public interface IUsuarioService {
    ResponseDto crearReserva(ReservaSaveDto reserva);
    ResponseDto Pagar(); // falta saber que le pongo de argumento
}
