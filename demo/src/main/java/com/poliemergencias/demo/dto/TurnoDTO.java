package com.poliemergencias.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TurnoDTO {
    private LocalDate fecha;
    private LocalTime horario;
    private Long sede;
    private Long  id_doctor;
    private boolean clinica;
    private Long idEstudio;
    private Long idEspecialidad;


    public TurnoDTO() {}

    public TurnoDTO( String fecha,String horario ,Long id_doctor, Long sede,Long idEstudio,Long idEspecialidad) {

        this.fecha = LocalDate.parse(fecha);
        this.horario=LocalTime.parse(horario);
        this.sede=sede;
        this.id_doctor=id_doctor;
        this.idEstudio = idEstudio;
        this.idEspecialidad=idEspecialidad;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = LocalDate.parse(fecha);
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public boolean isClinica() {
        if(idEstudio!=null) {
            this.clinica=false;

        }
        else{
            this.clinica=true;
        }
        return clinica;
    }

    public void setClinica(boolean clinica) {
        this.clinica = clinica;
    }



    public Long getSede() { return sede; }
    public void setSede(Long  sede) { this.sede = sede; }

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public Long getDoctor() { return id_doctor; }
    public void setDoctor(Long doctor) { this.id_doctor = doctor; }

    public Long getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Long idEstudio) {
        this.idEstudio = idEstudio;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario=LocalTime.parse(horario);    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}