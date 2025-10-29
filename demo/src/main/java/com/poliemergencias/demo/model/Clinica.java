package com.poliemergencias.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private Long id;
    @Column(name="info")
    private String info;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Clinica() {
    }

    public Clinica(Long id, String info, Turno turno) {
        this.id = id;
        this.info = info;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
