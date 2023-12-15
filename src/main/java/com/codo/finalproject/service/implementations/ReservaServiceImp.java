package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;

import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IComprobanteRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.interfaces.IReservaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReservaServiceImp implements IReservaService {
    private final IReservaRepository reservaRepository;
    private final IComprobanteRepository comprobanteRepository;
    private final ObjectMapper mapper;

    public ReservaServiceImp(IReservaRepository reservaRepository, IComprobanteRepository comprobanteRepository){
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
        Comprobante datosComprobante;
        Reserva datosReserva;
        try {
            datosComprobante = comprobanteRepository.findByCodigoComprobante(comprobanteEntity.getCodigoComprobante());
        } catch (Exception e) {
            return new ResponseDto("No se encuentra registrado el comprobante");
        }
        try {
            datosReserva = reservaRepository.findByIdComprobante(datosComprobante.getId());
        } catch (Exception e) {
            return new ResponseDto("El comprobante no esta asociado a una reserva");
        }

        if (!Objects.equals(comprobanteEntity.getMonto(), datosComprobante.getMonto())){
            return new ResponseDto("Montos diferentes correspondiente al comprobante." +
                                   " Recibido: " + comprobanteEntity.getMonto() +
                                   " Real: " + datosComprobante.getMonto());
        } else if (!Objects.equals(comprobanteEntity.getMetodoPago(), datosComprobante.getMetodoPago())){
            return new ResponseDto("Montos diferentes correspondiente al comprobante." +
                                   " Recibido: " + comprobanteEntity.getMetodoPago() +
                                   " Real: " + datosComprobante.getMetodoPago());
        } else {
            datosReserva.setPagada(true);
            reservaRepository.save(datosReserva);
            return new ResponseDto("Tu pago fue realizado con exito");
        }

    }



}
