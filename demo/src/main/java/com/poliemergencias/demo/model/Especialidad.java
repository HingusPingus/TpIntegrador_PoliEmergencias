package com.poliemergencias.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long id;
    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "especialidades")
    private List<Doctor> doctores;

    public Especialidad(List<Doctor> doctores, String nombre, Long id) {
        this.doctores = doctores;
        this.nombre = nombre;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }
}

