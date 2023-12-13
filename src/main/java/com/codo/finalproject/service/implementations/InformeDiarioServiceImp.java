package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.InformeDto;
import com.codo.finalproject.dto.response.InformeDiarioDto;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.entity.Vuelo;
import com.codo.finalproject.repository.interfaces.IInformeDiarioRepository;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.interfaces.IInformeDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformeDiarioServiceImp implements IInformeDiarioService {

    private IInformeDiarioRepository informeRepositorio;
    private IReservaRepository reservaRepositorio;
    private InformeDto informeDiario;
    private Reserva reserva;

    private List<Reserva> listaReserva;
    @Override
    public Integer cantidadDeVentasAlDia(LocalDate fecha) {
        return
                listaReserva.stream()
                .filter(reserva -> reserva.getFechaViaje().equals(fecha))
                .collect(Collectors.toList()).size();
        //Faltaría setearle ese valor al DTO y luego a la entidad... pero tengo que reveer el tema del mapped..
            }

    public Double recaudacionDiaria (LocalDate fecha){
        return listaReserva.stream()
                .filter ( reserva-> reserva.getFechaViaje().equals(fecha))
                .mapToDouble(r -> r.getComprobante_reserva().getMonto())
                .sum();
    }

    @Override
    public InformeDiarioDto getDestinosPopulares(LocalDate fecha) {
        List<Reserva> reservasPagadas = reservaRepositorio.getReservasByPagadaIsTrueAndFechaViajeEquals(fecha);
        List<Vuelo> vuelosPagados = reservasPagadas.stream()
                .map(Reserva::getVuelo_reserva)
                .toList();
        List<String> destinosPopulares = vuelosPagados.stream()
                .map(Vuelo::getAeropuertoDestino)
                .toList();

        InformeDiarioDto informeDiarioDto = new InformeDiarioDto();
        informeDiarioDto.setCantidadDeVentasDelDia(10);
        informeDiarioDto.setIngresos(100.0);
        informeDiarioDto.setFecha(null);
        informeDiarioDto.setDestinosPopulares(destinosPopulares);

        return informeDiarioDto;
    }

}