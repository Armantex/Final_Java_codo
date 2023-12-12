package com.codo.finalproject.controller;
import com.codo.finalproject.dto.request.idUsuarioDto;
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


    @GetMapping("/getInfo/Cliente/{idCliente}") // matias
    //User Story 4: Como agente de ventas, quiero poder acceder al historial de reservas y preferencias de viaje de un cliente
    public ResponseEntity<?>obtenerHistorialReserva(@PathVariable Long idCliente){
        return new ResponseEntity<>(reservaService.getHistorialReserva(idCliente),HttpStatus.OK);
    }
    @GetMapping("/getInfo/Cliente/{idCliente}") // matias
    //User Story 4: Como agente de ventas, quiero poder acceder al historial de reservas y preferencias de viaje de un cliente
    public ResponseEntity<?>obtenerInformacionDeCliente(@PathVariable Long idCliente){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    
}
