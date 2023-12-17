package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;

import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.dto.response.TopDestinoDto;
import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.exception.TopDestinoNotFoundException;
import com.codo.finalproject.repository.interfaces.IComprobanteRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.repository.interfaces.IUsuarioRepository;
import com.codo.finalproject.service.interfaces.IReservaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.util.Objects;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


@Service
public class ReservaServiceImp implements IReservaService {
    private final IReservaRepository reservaRepository;
    private final IUsuarioRepository usuarioRepository;
    private final IComprobanteRepository comprobanteRepository;
    private final ObjectMapper mapper;

    public ReservaServiceImp(IReservaRepository reservaRepository, IUsuarioRepository usuarioRepository, IComprobanteRepository comprobanteRepository){
        mapper = new ObjectMapper();
        this.reservaRepository = reservaRepository;
        this.comprobanteRepository = comprobanteRepository;
        this.usuarioRepository = usuarioRepository;

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

   /* @Override
    public List<HistorialReservaPorUsuarioDto> getHistorialReserva(Long idUsuario) {
        List<Reserva> listaRepo = reservaRepository.findAllByUsuarioId(idUsuario);
        String username = usuarioRepository.findById(idUsuario).orElseThrow().getNombre();
        if (listaRepo.isEmpty())
            throw new ReservaNotFoundException("No se encontró ninguna reserva para el usuario "+ username + " con ID: " + idUsuario);
        return listaRepo.stream()
                .map(reserva -> new HistorialReservaPorUsuarioDto(
                        reserva.getFechaViaje(),
                        reserva.getPagada(),
                        reserva.getReservas_usuario(),
                        reserva.getComprobante_reserva())
                ).toList();
    }*/


    public List<TopDestinoDto> getTopDestinationsByUserId(Long userId) {
        /*List<Object[]> list = reservaRepository.findTopDestinationsByUserId(userId);
        if (list.isEmpty()) {
            throw new TopDestinoNotFoundException("No se encontró ningun destino para el usuario con ID: " + userId);
        }
        return  list.stream()
                .map(dto -> new TopDestinoDto(
                        dto.getDestino(),
                        dto.getCantidadReservas()))
                .toList();*/
        return null;
    }
    @Override
    public List<TopDestinoDto> getTopDestinationByUser(Long userId, int rankingSize){
        List<Reserva> reservas = reservaRepository.findAllById(Collections.singleton(userId));
        String username = usuarioRepository.findById(userId).orElseThrow().getNombre();
        if (reservas.isEmpty()) throw new TopDestinoNotFoundException("No se encontro ningun destino para el usuario: "+ username);

        TreeMap<String,Long>destinos = new TreeMap<>();
        reservas.stream().map(r -> r.getReservas_vuelo().getAeropuertoDestino()).forEach(
                v -> {
                    if(destinos.containsKey(v)) {
                        destinos.put(v, destinos.get(v) + 1);
                    }else {
                        destinos.put(v, 1L);
                    }
                }
        );

        return rankingDestinosPopularesCalc(destinos,rankingSize);
    }

    private List<TopDestinoDto> rankingDestinosPopularesCalc(TreeMap<String,Long> lista, int rankingSize) {
        List<TopDestinoDto> destinoDtoList = new ArrayList<>();
        lista.put("Destino Generico 1", 2L);
        lista.put("Destino Generico 2", 5L);
        if (rankingSize <= 0) return destinoDtoList;
        if (rankingSize > lista.size()) rankingSize = lista.size();
        Long max = Collections.max(lista.values());

        do {
            Long entries = Collections.max(lista.values());
            String destino = "";
            for (Map.Entry<String, Long> entry : lista.entrySet()) {
                if (Objects.equals(entries, entry.getValue())) {
                    destino = entry.getKey();
                }
            }

            destinoDtoList.add(new TopDestinoDto(destino,entries));
            lista.remove(destino);
            rankingSize--;
            }while (rankingSize != 0);
            return destinoDtoList;
    }

}
