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

}
