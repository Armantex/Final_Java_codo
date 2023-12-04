package com.codo.finalproject.controller;
import jakarta.validation.Valid;
import com.codo.finalproject.dto.request.VueloDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlySkyController {


    //usuarioService
    @GetMapping("/getAll/VuelosDisp") // lean
    public ResponseEntity<?>obtenerVuelosDisponibles(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @GetMapping("/getInfo/Cliente/{idCliente}") // matias
    //User Story 4: Como agente de ventas, quiero poder acceder al historial de reservas y preferencias de viaje de un cliente
    public ResponseEntity<?>obtenerInformacionDeCliente(@PathVariable Long idCliente){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
