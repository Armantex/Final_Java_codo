package com.codo.finalproject.integration;

import com.codo.finalproject.dto.response.InformeDiarioDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

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

}