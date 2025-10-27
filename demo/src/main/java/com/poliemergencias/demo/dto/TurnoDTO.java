package com.poliemergencias.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private Long id;
    private LocalDate fechaPedido;
    private LocalDate fechaTurno;
    private LocalTime horario;
    private LocalTime duracion;
    private SedeDTO sede;
    private PacienteDTO cliente;
    private DoctorDTO doctor;
    private String estado;

    public TurnoDTO() {}

    public TurnoDTO(Long id, LocalDate fechaPedido, LocalDate fechaTurno, LocalTime horario,
                    LocalTime duracion, String estado) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaTurno = fechaTurno;
        this.horario = horario;
        this.duracion = duracion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public LocalDate getFechaTurno() { return fechaTurno; }
    public void setFechaTurno(LocalDate fechaTurno) { this.fechaTurno = fechaTurno; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }

    public LocalTime getDuracion() { return duracion; }
    public void setDuracion(LocalTime duracion) { this.duracion = duracion; }

    public SedeDTO getSede() { return sede; }
    public void setSede(SedeDTO sede) { this.sede = sede; }

    public PacienteDTO getCliente() { return cliente; }
    public void setCliente(PacienteDTO cliente) { this.cliente = cliente; }

    public DoctorDTO getDoctor() { return doctor; }
    public void setDoctor(DoctorDTO doctor) { this.doctor = doctor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}