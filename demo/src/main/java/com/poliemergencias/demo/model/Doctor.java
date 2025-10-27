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
    @Column(name="imagen")
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "especialidad_id_especialidad")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidad especialidades) {
        this.especialidades = especialidades;
    }

    public Sede[] getHospitales() {
        return hospitales;
    }

    public void setHospitales(Sede[] hospitales) {
        this.hospitales = hospitales;
    }

    public Set<ObraSocial> getObrasSocialesAtendidas() {
        return obrasSocialesAtendidas;
    }

    public void setObrasSocialesAtendidas(Set<ObraSocial> obrasSocialesAtendidas) {
        this.obrasSocialesAtendidas = obrasSocialesAtendidas;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
