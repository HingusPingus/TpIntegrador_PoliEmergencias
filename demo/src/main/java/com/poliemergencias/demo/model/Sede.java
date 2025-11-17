package com.poliemergencias.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Sede {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospital")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;

    @ManyToMany
    @JoinTable(name = "medico_has_hospital",
            joinColumns = @JoinColumn(name = "hospital_id_hospital"),
            inverseJoinColumns = @JoinColumn(name = "medico_usuario_id_usuario"))
    @JsonIgnore
    private List<Doctor> doctores;


    public Sede() {
    }

    public Sede(String nombre, String direccion, List<Doctor> hospitales) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.doctores = hospitales;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> hospitales) {
        this.doctores = hospitales;
    }

}
