package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "obra_social")
public class ObraSocial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_obra_social")
    private Long id;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "obraSocial")
    private List<Paciente> pacientes;

    public ObraSocial(Long id, String nombre, List<Paciente> pacientes) {
        this.id = id;
        this.nombre = nombre;
        this.pacientes = pacientes;
    }

    public ObraSocial() {
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

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}

