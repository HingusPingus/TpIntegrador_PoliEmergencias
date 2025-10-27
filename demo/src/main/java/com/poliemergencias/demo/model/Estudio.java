package com.poliemergencias.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudio")
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private Long id;
    @Column(name="informe")
    private String informe;
    @Column(name="tipo_estudio_id")
    private Long tipo_estudio_id;

    @ManyToOne
    private TipoEstudio tipo_estudio;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Estudio(Long id, String informe, Long tipo_estudio_id, TipoEstudio tipo_estudio, Turno turno) {
        this.id = id;
        this.informe = informe;
        this.tipo_estudio_id = tipo_estudio_id;
        this.tipo_estudio = tipo_estudio;
        this.turno = turno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Long getTipo_estudio_id() {
        return tipo_estudio_id;
    }

    public void setTipo_estudio_id(Long tipo_estudio_id) {
        this.tipo_estudio_id = tipo_estudio_id;
    }

    public TipoEstudio getTipo_estudio() {
        return tipo_estudio;
    }

    public void setTipo_estudio(TipoEstudio tipo_estudio) {
        this.tipo_estudio = tipo_estudio;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
