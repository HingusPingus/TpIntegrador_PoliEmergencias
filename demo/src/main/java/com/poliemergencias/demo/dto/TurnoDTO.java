package com.poliemergencias.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TurnoDTO {
    private LocalDateTime fecha;
    private Long sede;
    private Long  id_doctor;
    private boolean clinica;
    private Long idEstudio;


    public TurnoDTO() {}

    public TurnoDTO( LocalDateTime fecha, Long id_doctor, Long sede,Long idEstudio) {

        this.fecha = fecha;
        this.sede=sede;
        this.id_doctor=id_doctor;
        this.idEstudio=idEstudio;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public boolean isClinica() {
        return clinica;
    }

    public void setClinica(boolean clinica) {
        this.clinica = clinica;
    }



    public Long getSede() { return sede; }
    public void setSede(Long  sede) { this.sede = sede; }


    public Long getDoctor() { return id_doctor; }
    public void setDoctor(Long doctor) { this.id_doctor = doctor; }

    public Long getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Long idEstudio) {
        this.idEstudio = idEstudio;
    }
}