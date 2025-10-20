package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turno")
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente cliente;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Especialidad especialidad;

    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado; // RESERVADO, CANCELADO, FINALIZADO

    @Column(length = 2000)
    private String indicacionesProfesional; // feedback / resultados

    // getters/setters
    public enum EstadoTurno { RESERVADO, CANCELADO, FINALIZADO }
}
