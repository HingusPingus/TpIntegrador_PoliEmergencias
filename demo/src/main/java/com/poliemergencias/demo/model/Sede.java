package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Sede {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;

    @ManyToMany
    @JoinTable(name = "medico_has_hospital",
            joinColumns = @JoinColumn(name = "hospital_id_hospital"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id_usuario"))
    private List<Doctor> hospitales;

    // getters/setters
}
