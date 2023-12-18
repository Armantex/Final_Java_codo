package com.codo.finalproject;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.PasajeroDto;
import com.codo.finalproject.dto.request.ReservaDto;
import com.codo.finalproject.dto.request.UsuarioDto;
import com.codo.finalproject.dto.response.ComprobanteDto;
import com.codo.finalproject.dto.response.HistorialReservaPorUsuarioDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.dto.response.TopDestinoDto;
import com.codo.finalproject.entity.Asiento;
import com.codo.finalproject.entity.Usuario;
import com.codo.finalproject.service.implementations.ReservaServiceImp;
import com.codo.finalproject.util.MetodoPago;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservaServiceTest {
    @Autowired
    ReservaServiceImp reservaServiceImp;
    @Test
    public void pagarTestValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TB, 1608.19,723);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Tu pago fue realizado con exito");
        assertEquals(respuestaA,respuestaC);
    }
    @Test
    public void pagarTestMetodoPagoNotValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TC, 1608.19,723);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Montos diferentes correspondiente al comprobante. Recibido: TC Real: TB");
        assertEquals(respuestaA,respuestaC);
    }
    @Test
    public void pagarTestMontoNotValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TB, 999.9,723);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Montos diferentes correspondiente al comprobante. Recibido: 999.9 Real: 1608.19");
        assertEquals(respuestaA,respuestaC);
    }
    @Test
    public void pagarTestComprobanteNotValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TB, 999.9,9999);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("El comprobante no esta asociado a una reserva");
        assertEquals(respuestaA,respuestaC);
    }
    @Test
    public void getHistorialReservaOkTest(){
        //Arrange
        LocalDate fechaViaje = LocalDate.of(2023,2,2);
        UsuarioDto usuarioDto = new UsuarioDto("Nombre Generico 1",100001,"Domicilio Generico 1","Email Generico 1");
        ComprobanteDto comprobanteDto = new ComprobanteDto(11L,MetodoPago.TB,1608.19,723);
        HistorialReservaPorUsuarioDto expected = new HistorialReservaPorUsuarioDto(fechaViaje,true,usuarioDto,comprobanteDto);
        //Act
        HistorialReservaPorUsuarioDto actual = reservaServiceImp.getHistorialReserva(1L).get(0);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void getTopDestinationByUserOkTest(){
        //Arrange
        TopDestinoDto expected = new TopDestinoDto("Destino Generico 2", 5L);
        //Act
        TopDestinoDto actual = reservaServiceImp.getTopDestinationByUser(1L,1).get(0);
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void crearReservaOkTest(){
        //Arrange
        List<PasajeroDto> pasajeroDtoList = new ArrayList<>();
        List<Asiento> asientos = new ArrayList<>();
        pasajeroDtoList.add(new PasajeroDto("Nombre Generico 1","Apellido Generico 1"));
        asientos.add(new Asiento(1L,true,null,null));
        ReservaDto reserva = new ReservaDto(LocalDate.of(2023,12,12),true,pasajeroDtoList,asientos,new Usuario());
        ResponseDto expected =  new ResponseDto("La reserva se guardo correctamente.");
        //Act
        ResponseDto actual = reservaServiceImp.crearReserva(reserva);
        //Assert
        assertEquals(expected,actual);
    }
}
