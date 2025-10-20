package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id_usuario")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_obra_social")
    private ObraSocial obraSocial;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    // getters y setters
    public Paciente(){}

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id_usuario")
    private User user;

    public Paciente(User user, Long id, long idObraSocial) {
        this.user = user;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
