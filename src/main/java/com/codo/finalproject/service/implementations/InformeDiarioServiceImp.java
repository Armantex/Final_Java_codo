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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformeDiarioServiceImp implements IInformeDiarioService {

    private IInformeDiarioRepository informeRepositorio;
    private IReservaRepository reservaRepositorio;
    private InformeDto informeDiario;
    private Reserva reserva;

    public InformeDiarioServiceImp(IInformeDiarioRepository iInformeDiarioRepository, IReservaRepository iReservaRepository){
        this.informeRepositorio = iInformeDiarioRepository;
        this.reservaRepositorio = iReservaRepository;
    }

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

        if(reservasPagadas.isEmpty()){
            throw new NoReservasForReporteException("No hay reservas pagadas para la fecha elegida.");
        }

        List<Vuelo> vuelosPagados = reservasPagadas.stream()
                .map(Reserva::getReservas_vuelo)
                .toList();
        List<String> destinosPopulares = vuelosPagados.stream()
                .map(Vuelo::getAeropuertoDestino)
                .toList();

        InformeDiarioDto informeDiarioDto = new InformeDiarioDto();
        informeDiarioDto.setCantidadDeVentasDelDia(10); //Completar con lo de Carla
        informeDiarioDto.setIngresos(100.0); // Completar con lo de Carla
        informeDiarioDto.setFecha(fecha);
        informeDiarioDto.setDestinosPopulares(destinosPopulares);

        return informeDiarioDto;
    }

}