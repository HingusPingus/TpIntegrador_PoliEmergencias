package com.poliemergencias.demo.dto;

public class TipoEstudioDTO {
    private String nombre;

    public TipoEstudioDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
