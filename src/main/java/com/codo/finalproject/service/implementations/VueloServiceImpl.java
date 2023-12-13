package com.codo.finalproject.service.implementations;

import com.codo.finalproject.dto.request.VueloDto;
import com.codo.finalproject.entity.Vuelo;
import com.codo.finalproject.exception.NoFlightsAvailableException;
import com.codo.finalproject.repository.interfaces.IVueloRepository;
import com.codo.finalproject.service.interfaces.IVueloService;
import com.codo.finalproject.util.Aerolineas;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VueloServiceImpl implements IVueloService {

    IVueloRepository vueloRepository;

    public VueloServiceImpl(IVueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
        //vueloGenerico();
    }

    @Override
    public List<VueloDto> buscarDisponibles() {
        ModelMapper mapper = new ModelMapper();
        List<Vuelo> vuelosEnt = vueloRepository.findByIsFullFalse();
        if(vuelosEnt.isEmpty())throw new NoFlightsAvailableException("No se encontraron vuelos disponibles.");
        List<VueloDto> vueloDto = new ArrayList<>();
        vuelosEnt.stream().forEach(v -> vueloDto.add((mapper.map(v, VueloDto.class))));
        return vueloDto;
    }

    private void vueloGenerico(){
        //LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.of(2025,10,2,14,50,0);
        Vuelo vuelo = new Vuelo(1L,null,time2,"Ezeiza","Madrid",80000.0,"asd",false,(short) 30,Aerolineas.SKY.toString(),null,null);
        vueloRepository.save(vuelo);
        Vuelo vuelo2 = new Vuelo(2L,null,time2,"Cordoba","Bariloche", 30000.0,"asd",true, (short) 0,Aerolineas.AEROLINEASARG.toString(),null,null);
        vueloRepository.save(vuelo2);
    }

}
