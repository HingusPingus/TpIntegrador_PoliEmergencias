package com.poliemergencias.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "turno")
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private Long id;
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;
    @Column(name="fecha_turno")
    private LocalDate fechaTurno;
    @Column(name = "horario")
    private LocalTime horario;
    @Column(name="duracion")
    private LocalTime duracion;
    @ManyToOne
    private Sede sede;
    @ManyToOne
    private Paciente cliente;

    @ManyToOne
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado; // RESERVADO, CANCELADO, FINALIZADO


    // getters/setters
    public enum EstadoTurno { RESERVADO, CANCELADO, FINALIZADO }

    public Turno(Long id, LocalDate fechaPedido, LocalDate fechaTurno, LocalTime horario, LocalTime duracion, Sede sede, Paciente cliente, Doctor doctor, Especialidad especialidad, EstadoTurno estado, String indicacionesProfesional) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaTurno = fechaTurno;
        this.horario = horario;
        this.duracion = duracion;
        this.sede = sede;
        this.cliente = cliente;
        this.doctor = doctor;
        this.estado = estado;
    }
}
