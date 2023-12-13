package com.codo.finalproject.controller;

import com.codo.finalproject.service.interfaces.IExtrasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtrasController {
    //Controller para acciones fuera de la entrega del TP
    IExtrasService eService;

    public ExtrasController(IExtrasService eService) {
        this.eService = eService;
    }

    @PostMapping("/extra/{cantidad}")
    public ResponseEntity<?>CargarBaseDeDatos(@PathVariable int cantidad){
        return new ResponseEntity<>(eService.cargarBaseDeDatos(cantidad), HttpStatus.OK);
    }
}
