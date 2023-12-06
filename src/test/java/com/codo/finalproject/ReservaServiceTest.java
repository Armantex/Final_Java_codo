package com.codo.finalproject;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.service.implementations.ReservaServiceImp;
import com.codo.finalproject.util.MetodoPago;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservaServiceTest {
    @Autowired
    ReservaServiceImp reservaServiceImp;
    @Test
    public void pagarTestValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TC, 105.25,182);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Tu pago fue realizado con exito");
        assertEquals(respuestaA,respuestaC);
    }
    @Test
    public void pagarTestNotValid(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TC, 105.25,184);
        ResponseDto respuestaA = reservaServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Tu pago fue rechazado");
        assertEquals(respuestaA,respuestaC);
    }
}
