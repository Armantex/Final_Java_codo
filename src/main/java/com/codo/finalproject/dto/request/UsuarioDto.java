package com.codo.finalproject.dto.request;

import com.codo.finalproject.util.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    private String nombre;
    private Integer telefono;
    private String domicilio;
    private String email;
}
