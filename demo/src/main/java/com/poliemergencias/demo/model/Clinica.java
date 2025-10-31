package com.poliemergencias.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @Column(name="id_turno")
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Clinica() {
    }

    public Clinica(Long id, String info, Turno turno) {
        this.id = id;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
