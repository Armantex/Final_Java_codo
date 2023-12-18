package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;

import com.codo.finalproject.dto.request.UsuarioDto;
import com.codo.finalproject.dto.response.ComprobanteDto;
import com.codo.finalproject.dto.response.HistorialReservaPorUsuarioDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.dto.response.TopDestinoDto;
import com.codo.finalproject.entity.Comprobante;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.entity.Usuario;
import com.codo.finalproject.exception.ReservaNotFoundException;
import com.codo.finalproject.exception.TopDestinoNotFoundException;
import com.codo.finalproject.repository.interfaces.IComprobanteRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.repository.interfaces.IUsuarioRepository;
import com.codo.finalproject.service.interfaces.IReservaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Objects;

import java.util.*;
import java.util.stream.Collectors;


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
        Reserva datosReserva;
        Comprobante datosComprobante = comprobanteRepository.findByCodigoComprobante(comprobanteEntity.getCodigoComprobante());
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

    @Override
    public List<HistorialReservaPorUsuarioDto> getHistorialReserva(Long idUsuario) {
        ModelMapper modelMapper = new ModelMapper();
        List<Reserva> listaRepo = reservaRepository.findAllByUsuarioId(idUsuario);
        List<HistorialReservaPorUsuarioDto> historial = new ArrayList<>();
        String username = usuarioRepository.findById(idUsuario).orElseThrow().getNombre();
        if (listaRepo.isEmpty())
            throw new ReservaNotFoundException("No se encontró ninguna reserva para el usuario "+ username + " con ID: " + idUsuario);
        listaRepo
                .forEach(reserva ->{
                        boolean pagada = reserva.getComprobante_reserva().getMonto() != 0;
                    historial.add(new HistorialReservaPorUsuarioDto(
                        reserva.getFechaViaje(),
                        pagada,
                        modelMapper.map(reserva.getReservas_usuario(),UsuarioDto.class),
                        modelMapper.map(reserva.getComprobante_reserva(), ComprobanteDto.class)
                    ));
                });
        return historial;
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
