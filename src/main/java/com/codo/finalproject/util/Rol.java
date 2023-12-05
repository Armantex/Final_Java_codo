package com.codo.finalproject.util;

public enum Rol {
    C("Cliente"),ADMIN("Administrador"),AG_VIAJE("Agente de viaje");

    private String rol;

    Rol (String rol){
        this.rol = rol;
    }

    @Override
    public String toString() {
        return rol;
    }
}
