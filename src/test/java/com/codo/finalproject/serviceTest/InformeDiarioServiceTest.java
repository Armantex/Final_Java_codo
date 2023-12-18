package com.codo.finalproject.serviceTest;

import com.codo.finalproject.dto.response.InformeDiarioDto;
import com.codo.finalproject.entity.Pasajero;
import com.codo.finalproject.entity.Reserva;
import com.codo.finalproject.entity.Vuelo;
import com.codo.finalproject.exception.NoReservasForReporteException;
import com.codo.finalproject.repository.interfaces.IReservaRepository;
import com.codo.finalproject.service.implementations.InformeDiarioServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InformeDiarioServiceTest {

    @Mock
    private IReservaRepository reservaRepository;

    @InjectMocks
    InformeDiarioServiceImp informeDiarioService;

    @Test
    public void reservasPagadasVaciaTest(){
        LocalDate fecha = LocalDate.now();
        List<Reserva> reservasPagadasEmpty = new ArrayList<>();

        when(reservaRepository.getReservasByPagadaIsTrueAndFechaViajeEquals(fecha))
                .thenReturn(reservasPagadasEmpty);

        assertThrows(NoReservasForReporteException.class, () ->
                informeDiarioService.generarInformeDiario(fecha));
    }

    @Test
    public void informeDiarioGeneradoCorrectamenteTest(){
        // Arrange
        Vuelo vuelo1 = new Vuelo();
        vuelo1.setAeropuertoDestino("Aeropuerto Jujuy");
        vuelo1.setPrecio(60000.0);
        Vuelo vuelo2 = new Vuelo();
        vuelo2.setAeropuertoDestino("Aeropuerto Cordoba");
        vuelo2.setPrecio(40000.0);

        Pasajero pasajero1 = new Pasajero();
        pasajero1.setNombre("P1");
        Pasajero pasajero2= new Pasajero();
        pasajero2.setNombre("P2");
        Pasajero pasajero3 = new Pasajero();
        pasajero3.setNombre("P3");
        Set<Pasajero> pasajerosReserva1 = new HashSet<>();
        pasajerosReserva1.add(pasajero1);
        Set<Pasajero> pasajerosReserva2 = new HashSet<>();
        pasajerosReserva2.add(pasajero2);
        pasajerosReserva2.add(pasajero3);

        Reserva reserva1 =  new Reserva();
        reserva1.setReservas_vuelo(vuelo1);
        reserva1.setPasajeros(pasajerosReserva1);
        Reserva reserva2 =  new Reserva();
        reserva2.setReservas_vuelo(vuelo2);
        reserva2.setPasajeros(pasajerosReserva2);

        List<Reserva> reservasSimuladas = new ArrayList<>();
        reservasSimuladas.add(reserva1);
        reservasSimuladas.add(reserva2);

        int ventasEsperadas = 3;
        double recaudacionEsperada = 140000;
        Map<String, Long> destinosEsperados = new HashMap<>();
        destinosEsperados.put("Aeropuerto Jujuy", 1L);
        destinosEsperados.put("Aeropuerto Cordoba", 1L);

        LocalDate fecha = LocalDate.now();

        // Act
        when(reservaRepository.getReservasByPagadaIsTrueAndFechaViajeEquals(fecha))
                .thenReturn(reservasSimuladas);
        InformeDiarioDto informeDiarioDto = informeDiarioService.generarInformeDiario(fecha);

        // Assert
        assertEquals(ventasEsperadas, informeDiarioDto.getCantidadDeVentasDelDia());
        assertEquals(recaudacionEsperada, informeDiarioDto.getIngresos());
        assertEquals(destinosEsperados, informeDiarioDto.getDestinosPopulares());
        assertEquals(fecha, informeDiarioDto.getFecha());
    }
}
