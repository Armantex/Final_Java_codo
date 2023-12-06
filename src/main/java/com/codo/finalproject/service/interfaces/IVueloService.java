package com.codo.finalproject.service.interfaces;

import com.codo.finalproject.dto.request.VueloDto;

import java.util.List;

public interface IVueloService {
    List<VueloDto> buscarDisponibles();
}
