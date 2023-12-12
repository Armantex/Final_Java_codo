package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.request.VueloDto;
import com.codo.finalproject.dto.response.ResponseDto;

import java.util.List;


public interface IReservaService {
    ResponseDto crearReserva(ReservaDto reserva);
    ResponseDto pagar(PagoDto pagoDto); // falta saber que le pongo de argumento
    ResponseDto historialReserva(idUsuarioDto idUsuario);
}
