package com.poliemergencias.demo.model;

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
            inverseJoinColumns = @JoinColumn(name = "usuario_id_usuario"))
    private List<Doctor> hospitales;

    @OneToMany(mappedBy = "sede")
    private List<Turno> turnos;

    public Sede() {
    }

    public Sede(String nombre, String direccion, List<Doctor> hospitales, List<Turno> turnos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.hospitales = hospitales;
        this.turnos = turnos;
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

    public List<Doctor> getHospitales() {
        return hospitales;
    }

    public void setHospitales(List<Doctor> hospitales) {
        this.hospitales = hospitales;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
}
