package com.codo.finalproject.integration;

import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.response.InformeDiarioDto;
import com.codo.finalproject.util.MetodoPago;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.antlr.v4.runtime.misc.MultiMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void generarInformeDiarioOkTest() throws Exception {
        MvcResult response = mockMvc.perform(get("/generarInformeDiario").param("fecha", String.valueOf(LocalDate.of(2023, 2, 2))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("cantidadDeVentasDelDia").value(2))
                .andReturn();
        assertEquals("application/json", response.getResponse().getContentType());
    }
    @Test
    void obtenerVuelosDisponiblesOkTest() throws Exception {
        MvcResult response = mockMvc.perform(get("/getAll/VuelosDisp"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andReturn();
        assertEquals("application/json", response.getResponse().getContentType());
    }

    @Test
    void obtenerDestinosPopularesOkTest() throws Exception {
        MvcResult response = mockMvc.perform(get("/getInfo/cliente/preferencias/1/1?id=1&rankingSize=2")

        )       .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].destino").value("Destino Generico 2"))
                .andExpect(jsonPath("$[1].destino").value("Destino Generico 1"))
                .andReturn();
        assertEquals("application/json", response.getResponse().getContentType());
    }

    @Test
    void obtenerHistorialReservaOkTest() throws Exception{
        MvcResult response = mockMvc.perform(get("/getInfo/cliente/historial/{idCliente}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fechaViaje").value(LocalDate.of(2023,2,2).toString()))
                .andReturn();
        assertEquals("application/json", response.getResponse().getContentType());
    }

    @Test
    void pagarOkTest() throws Exception{
        PagoDto pagoTest = new PagoDto(MetodoPago.TB, 1608.19,723);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(pagoTest);

        MvcResult response = mockMvc.perform(post("/usuario/pagar").contentType("application/json").content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("application/json", response.getResponse().getContentType());
    }

}