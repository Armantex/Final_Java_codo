package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.InformeDto;
import com.codo.finalproject.dto.response.InformeDiarioDto;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.entity.Vuelo;
import com.codo.finalproject.exception.NoReservasForReporteException;
import com.codo.finalproject.repository.interfaces.IInformeDiarioRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.interfaces.IInformeDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InformeDiarioServiceImp implements IInformeDiarioService {

    private IReservaRepository reservaRepositorio;

    public InformeDiarioServiceImp(IReservaRepository iReservaRepository){
        this.reservaRepositorio = iReservaRepository;
    }


    @Override
    public InformeDiarioDto generarInformeDiario(LocalDate fecha) {
        // Reservas pagadas para una fecha dada
        List<Reserva> reservasPagadas = reservaRepositorio.getReservasByPagadaIsTrueAndFechaViajeEquals(fecha);

        if(reservasPagadas.isEmpty()){
            throw new NoReservasForReporteException("No hay reservas pagadas para la fecha elegida.");
        }

        int cantidadDePasajesVendidos = 0;
        double recaudacioDiaria = 0;
        List<String> destinosPopulares = new ArrayList<>();

        for(Reserva r : reservasPagadas){
            cantidadDePasajesVendidos += r.getPasajeros().size();
            recaudacioDiaria += r.getPasajeros().size() * r.getReservas_vuelo().getPrecio();
            destinosPopulares.add(r.getReservas_vuelo().getAeropuertoDestino());
        }

        Map<String, Long> conteoPorDestinos = destinosPopulares.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        InformeDiarioDto informeDiarioDto = new InformeDiarioDto();
        informeDiarioDto.setCantidadDeVentasDelDia(cantidadDePasajesVendidos);
        informeDiarioDto.setIngresos(recaudacioDiaria);
        informeDiarioDto.setFecha(fecha);
        informeDiarioDto.setDestinosPopulares(conteoPorDestinos);

        return informeDiarioDto;
    }

}