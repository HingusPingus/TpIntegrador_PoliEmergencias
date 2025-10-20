package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "obra_social")
public class ObraSocial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "obraSocial")
    private List<Paciente> pacientes;

    // getters/setters
}

