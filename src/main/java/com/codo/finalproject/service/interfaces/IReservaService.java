package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.response.HistorialReservaPorUsuarioDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.dto.response.TopDestinoDto;
import java.util.List;


public interface IReservaService {
    ResponseDto crearReserva(ReservaDto reserva);
    ResponseDto pagar(PagoDto pagoDto); // falta saber que le pongo de argumento
    List<HistorialReservaPorUsuarioDto> getHistorialReserva(Long idUsuario);
    List<TopDestinoDto> getTopDestinationsByUserId(Long userId);
}
