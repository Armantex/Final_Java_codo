package com.codo.finalproject.controller;

import com.codo.finalproject.service.interfaces.IInformeDiarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class ReportesController {

    private IInformeDiarioService informeDiarioService;

    public ReportesController(IInformeDiarioService informeDiarioService){
        this.informeDiarioService = informeDiarioService;
    }

      @GetMapping("/generarInformeDiario") // Misael
    public ResponseEntity<?>obtenerDestinoPopular(@RequestParam("fecha") LocalDate fecha){
        return new ResponseEntity<>(informeDiarioService.generarInformeDiario(fecha),HttpStatus.OK);
    }
}
