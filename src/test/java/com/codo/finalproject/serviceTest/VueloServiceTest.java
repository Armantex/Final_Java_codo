package com.codo.finalproject.serviceTest;

import com.codo.finalproject.dto.request.VueloDto;
import com.codo.finalproject.service.interfaces.IVueloService;
import com.codo.finalproject.util.Aerolineas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class VueloServiceTest {

    @Autowired
    IVueloService vueloService;


    @Test
    public void getVuelosOkTest(){
        //Arrange
        VueloDto expected = new VueloDto(2L,null,null,"Aeroparque, Jorge Newbery","Bariloche, Teniente Luis Candelaria",199998.6, Aerolineas.AEROLINEASARG.toString(),false, (short) 14);
        //Act
        List<VueloDto> result = vueloService.buscarDisponibles();
        VueloDto actual = result.get(0);
        actual.setHorarioFinal(null);
        actual.setHorarioInicio(null);
        //Assert
        assertEquals(expected,result.get(0));

    }

}
