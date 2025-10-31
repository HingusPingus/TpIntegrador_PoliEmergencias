package com.poliemergencias.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "estudio")
public class Estudio {
    @Id
    @Column(name="id_turno")
    private Long id;
    @Column(name="tipo_estudio_id")
    private Long tipo_estudio_id;

    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Estudio() {
    }

    public Estudio(Long id, Long tipo_estudio_id, TipoEstudio tipo_estudio, Turno turno) {
        this.id = id;
        this.tipo_estudio_id = tipo_estudio_id;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipo_estudio_id() {
        return tipo_estudio_id;
    }

    public void setTipo_estudio_id(Long tipo_estudio_id) {
        this.tipo_estudio_id = tipo_estudio_id;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
