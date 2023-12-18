package com.codo.finalproject.controller;
import com.codo.finalproject.dto.request.PagoDto;
import com.codo.finalproject.dto.request.ReservaDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codo.finalproject.service.interfaces.IReservaService;
import com.codo.finalproject.service.implementations.ReservaServiceImp;

@RestController
public class RerservaController {
    private final IReservaService service;
    public RerservaController(ReservaServiceImp service){
        this.service = service;
    }
    @PostMapping("/usuario/reserva") // armando
    public ResponseEntity<?>crearReserva(@RequestBody @Valid ReservaDto reserva){
        return new ResponseEntity<>(service.crearReserva(reserva),HttpStatus.OK);
    }

    @PostMapping("/usuario/pagar") // armando
    public ResponseEntity<?>pagar(@RequestBody @Valid PagoDto pagoDto){
        return new ResponseEntity<>(service.pagar(pagoDto),HttpStatus.OK);
    }

}
