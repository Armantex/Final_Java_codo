package com.codo.finalproject.controller;
import com.codo.finalproject.service.interfaces.IVueloService;
import com.codo.finalproject.service.interfaces.IReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlySkyController {

    IVueloService vueloService;
    IReservaService reservaService;

    public FlySkyController(IVueloService vueloService , IReservaService reservaService ) {
        this.vueloService = vueloService;
        this.reservaService = reservaService;
    }

    //usuarioService
    @GetMapping("/getAll/VuelosDisp") // lean
    public ResponseEntity<?>obtenerVuelosDisponibles(){
        return new ResponseEntity<>(vueloService.buscarDisponibles(), HttpStatus.OK);
    }


    @GetMapping("/getInfo/cliente/historial/{idCliente}") // matias
    //User Story 4.1: Como agente de ventas, quiero poder acceder al historial de reservas
    public ResponseEntity<?>obtenerHistorialReserva(@PathVariable Long idCliente){
        return new ResponseEntity<>(reservaService.getHistorialReserva(idCliente),HttpStatus.OK);
    }
    @GetMapping("/getInfo/cliente/preferencias/{idCliente}/{rankingSize}") // matias
    //User Story 4.2: Como agente de ventas, quiero poder acceder a preferencias de viaje de un cliente
    public ResponseEntity<?>obtenerInformacionDeCliente(@RequestParam(name="id") Long idCliente,@RequestParam int rankingSize){
        return new ResponseEntity<>(reservaService.getTopDestinationByUser(idCliente, rankingSize),HttpStatus.OK);
    }
    
}
