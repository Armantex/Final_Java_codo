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
        LocalDateTime time2 = LocalDateTime.of(2025,10,2,14,50,0);
        List<VueloDto> expected = new ArrayList<>();
        VueloDto vuelo_a = new VueloDto(1L,null,time2,"Ezeiza","Madrid",80000.0, Aerolineas.SKY.toString(),false, (short) 30);
        expected.add(vuelo_a);
        //Act
        List<VueloDto> result = vueloService.buscarDisponibles();
        //Assert
        assertEquals(expected,result);

    }

}
