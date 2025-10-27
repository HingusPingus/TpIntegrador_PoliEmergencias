package com.poliemergencias.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private LocalDate fecha;
    private LocalTime horario;
    private String sede;
    private Long  id_doctor;
    private boolean clinica;


    public TurnoDTO() {}

    public TurnoDTO(Long id, LocalDate fechaPedido, LocalDate fechaTurno, LocalTime horario,
                    LocalTime duracion, String estado) {

        this.fecha = fechaTurno;
        this.horario = horario;
    }





    public LocalDate getFechaTurno() { return fecha; }
    public void setFechaTurno(LocalDate fechaTurno) { this.fecha = fechaTurno; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }



    public String getSede() { return sede; }
    public void setSede(String  sede) { this.sede = sede; }


    public Long getDoctor() { return id_doctor; }
    public void setDoctor(Long doctor) { this.id_doctor = doctor; }

}