package com.poliemergencias.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private LocalDate fecha;
    private LocalTime horario;
    private Long sede;
    private Long  id_doctor;
    private boolean clinica;
    private Long idEstudio;


    public TurnoDTO() {}

    public TurnoDTO( LocalDate fecha, LocalTime horario, Long id_doctor, Long sede,Long idEstudio) {

        this.fecha = fecha;
        this.horario = horario;
        this.sede=sede;
        this.id_doctor=id_doctor;
        this.idEstudio=idEstudio;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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


    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }



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