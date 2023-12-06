package com.codo.finalproject.util;

public enum Aerolineas {
    AEROLINEASARG("Aerolíneas Argentinas"),FLYBONDI("Flybondi"),JETSMART("JetSMART"),SKY("Sky Airline");

    private String aerolinea;

    Aerolineas(String aerolinea){this.aerolinea = aerolinea;}

    @Override
    public String toString(){return aerolinea;}
}
