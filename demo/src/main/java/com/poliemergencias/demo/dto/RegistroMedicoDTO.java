package com.poliemergencias.demo.dto;

import java.time.LocalDate;

public class RegistroMedicoDTO {
    private Long id;
    private LocalDate fechaTurno;
    private String info;
    private PacienteDTO paciente;

    // Constructors
    public RegistroMedicoDTO() {}

    public RegistroMedicoDTO(Long id, LocalDate fechaTurno, String info) {
        this.id = id;
        this.fechaTurno = fechaTurno;
        this.info = info;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaTurno() { return fechaTurno; }
    public void setFechaTurno(LocalDate fechaTurno) { this.fechaTurno = fechaTurno; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public PacienteDTO getPaciente() { return paciente; }
    public void setPaciente(PacienteDTO paciente) { this.paciente = paciente; }
}
