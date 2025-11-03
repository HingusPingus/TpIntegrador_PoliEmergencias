package com.poliemergencias.demo.dto;

import java.time.LocalTime;

public class TurnoFinDTO {
    private LocalTime duracion;
    private String informe;

    public TurnoFinDTO(String duracion, String informe) {
        this.duracion = LocalTime.parse(duracion);
        this.informe = informe;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
}
