package com.codo.finalproject.controller;
import jakarta.validation.Valid;
import com.codo.finalproject.dto.request.VueloDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlySkyController {
    
    @GetMapping("/getAll/VuelosDisp")
    public ResponseEntity<?>obtenerVuelosDisponibles(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/reserva/{id}")
    //UserStory1 "...para poder elegir el vuelo que mejor se adapte a mis necesidades."
    //Se obtienen todos los vuelos disponibles y su id, el usuario elige por id que vuelo selecciona para su compra
    public ResponseEntity<?>realizarCompraPorId(@PathVariable Long id){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PostMapping("/reserva")
    public ResponseEntity<?>realizarReserva(@RequestBody @Valid VueloDto vueloDto){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/Cliente/{idCliente}")
    //User Story 4: Como agente de ventas, quiero poder acceder al historial de reservas y preferencias de viaje de un cliente
    public ResponseEntity<?>obtenerInformacionDeCliente(@PathVariable Long idCliente){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario")
    public ResponseEntity<?>obtenerInformeDiarioCompleto(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/VentasDelDia")
    public ResponseEntity<?>obtenerVentasDelDia(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/IngresosDelDia")
    public ResponseEntity<?>obtenerIngresosDelDia(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping("/getInfo/InformeDiario/DestinoPopular")
    public ResponseEntity<?>obtenerDestinoPopular(){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }


}
