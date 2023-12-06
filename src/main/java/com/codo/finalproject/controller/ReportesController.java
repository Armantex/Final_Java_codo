package com.codo.finalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
@RestController
public class ReportesController {


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

    @GetMapping("/getInfo/InformeDiario/DestinoPopular") // ale
    public ResponseEntity<?>obtenerDestinoPopular(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/TendenciaReservas") // carla
    public ResponseEntity<?>obtenerTendenciaReservas(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
