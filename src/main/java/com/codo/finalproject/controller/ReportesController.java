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


    @GetMapping("/getInfo/InformeDiario")
    public ResponseEntity<?> obtenerInformeDiarioCompleto(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/VentasDelDia") // ale
    //Listado de boletosDTO
    public ResponseEntity<?>obtenerVentasDelDia(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/IngresosDelDia") // carla
    // La cantidad de $ recaudada en el día
    public ResponseEntity<?>obtenerIngresosDelDia(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/informeDiario") // Misael
    public ResponseEntity<?>obtenerDestinoPopular(@RequestParam("fecha") LocalDate fecha){
        return new ResponseEntity<>(informeDiarioService.generarInformeDiario(fecha),HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/TendenciaReservas") // carla
    public ResponseEntity<?>obtenerTendenciaReservas(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
