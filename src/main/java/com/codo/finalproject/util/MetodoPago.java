package com.codo.finalproject.util;

public enum MetodoPago {
    TB("Transferencia Bancaria"),TC("Tarjeta de Credito");

    private final String metodoPago;

    MetodoPago(String metodoPago){
        this.metodoPago = metodoPago;
    }

}
