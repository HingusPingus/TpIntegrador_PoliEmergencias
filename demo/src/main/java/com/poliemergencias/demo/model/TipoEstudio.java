package com.poliemergencias.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipo_estudio")
public class TipoEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_estudio")
    private Long id;
    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "tipo_estudio")
    private List<Estudio> estudios;

    public TipoEstudio(Long id, String nombre, List<Estudio> estudios) {
        this.id = id;
        this.nombre = nombre;
        this.estudios = estudios;
    }

    public TipoEstudio() {
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

    public List<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }
}
