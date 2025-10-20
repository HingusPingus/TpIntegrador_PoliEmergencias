package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historia_medico")
public class RegistroMedico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_usuario_id_usuario")
    private Long id;
    @Column(name="fecha_turno")
    private LocalDate fechaTurno;
    @Column(name = "info")
    private String info;

    @ManyToOne
    private Paciente paciente;


    public RegistroMedico(Long id, LocalDate fechaTurno, String info, Paciente paciente) {
        this.id = id;
        this.fechaTurno = fechaTurno;
        this.info = info;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
