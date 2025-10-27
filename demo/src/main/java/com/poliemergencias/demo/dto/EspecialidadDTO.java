package com.poliemergencias.demo.dto;

public class EspecialidadDTO {
    private String nombre;

    public EspecialidadDTO() {}

    public EspecialidadDTO( String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}