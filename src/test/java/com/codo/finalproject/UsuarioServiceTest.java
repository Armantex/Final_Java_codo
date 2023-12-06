package com.codo.finalproject;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.response.ResponseDto;
import com.codo.finalproject.service.implementations.UsuarioServiceImp;
import com.codo.finalproject.util.MetodoPago;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    UsuarioServiceImp usuarioServiceImp;
    @Test
    public void pagarTest(){
        PagoDto pagoTest = new PagoDto(MetodoPago.TC, 105.25,183);
        ResponseDto respuestaA = usuarioServiceImp.pagar(pagoTest);
        ResponseDto respuestaC = new ResponseDto("Estamos Comprobando tu pago");
        assertEquals(respuestaA,respuestaC);
    }
}
