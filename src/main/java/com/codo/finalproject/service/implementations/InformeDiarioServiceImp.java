package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.InformeDto;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.repository.interfaces.IInformeDiarioRepository;
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

}