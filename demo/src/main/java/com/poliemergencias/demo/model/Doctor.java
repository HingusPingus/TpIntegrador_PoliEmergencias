package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "medico")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id_usuario")
    private Long id;
    @Column(name = "telefono")
    private int telefono;


    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidades;


    @ManyToMany
    @JoinTable(name = "medico_has_hospital",
            joinColumns = @JoinColumn(name = "usuario_id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "hospital_id_hospital"))
    private Sede[] hospitales;

    @ManyToMany
    @JoinTable(name = "doctor_obra_social",
            joinColumns = @JoinColumn(name = "usuario_id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "obra_social_id_obra_social"))
    private Set<ObraSocial> obrasSocialesAtendidas;

    @OneToMany(mappedBy = "doctor")
    private List<Turno> turnos;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id_usuario")
    private User user;

}
