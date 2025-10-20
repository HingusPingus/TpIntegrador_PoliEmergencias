package com.poliemergencias.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "especialidades")
    private List<Doctor> doctores;

    // getters/setters
}

