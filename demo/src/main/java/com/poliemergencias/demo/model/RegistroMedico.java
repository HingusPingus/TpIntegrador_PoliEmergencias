package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historia_medico")
public class RegistroMedico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Turno turno; // si corresponde

    private LocalDateTime fecha;
    @Column(length = 4000)
    private String descripcion; // indicaciones, diagnóstico, resultados de estudio

    // getters/setters
}
