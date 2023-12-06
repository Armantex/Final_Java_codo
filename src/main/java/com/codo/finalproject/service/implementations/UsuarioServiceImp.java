package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.request.VueloDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IComprobanteRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.interfaces.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
@Service
public class UsuarioServiceImp implements IUsuarioService {
    private final IReservaRepository reservaRepository;
    private final IComprobanteRepository comprobanteRepository;
    private final ObjectMapper mapper;

    public UsuarioServiceImp(IReservaRepository reservaRepository, IComprobanteRepository comprobanteRepository){
        mapper = new ObjectMapper();
        this.reservaRepository = reservaRepository;
        this.comprobanteRepository = comprobanteRepository;
    }

    @Override
    public ResponseDto crearReserva(ReservaDto reserva) {
        Reserva reservaEntity = mapper.convertValue(reserva, Reserva.class);
        reservaRepository.save(reservaEntity);
        return new ResponseDto("La reserva se guardo correctamente.");
    }

    @Override
    public ResponseDto pagar(PagoDto pagoDto) {
        Comprobante comprobanteEntity = mapper.convertValue(pagoDto, Comprobante.class);
        Comprobante datosComprobante = comprobanteRepository.findByCodigoComprobante(comprobanteEntity.getCodigoComprobante());
        if (datosComprobante != null) {
            return new ResponseDto(comprobanteEntity.toString());
        }
        return new ResponseDto("Estamos Comprobando tu pago");
    }

    @Override
    public VueloDto vuelosDisponibles() {
        return null;
    }


}
