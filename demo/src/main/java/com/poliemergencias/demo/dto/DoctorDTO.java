package com.poliemergencias.demo.dto;

import java.util.Set;

public class DoctorDTO {
    private Long id;
    private int telefono;
    private EspecialidadDTO especialidad;
    private Set<ObraSocialDTO> obrasSocialesAtendidas;
    private UserDTO user;

    public DoctorDTO() {}

    public DoctorDTO(Long id, int telefono, EspecialidadDTO especialidad) {
        this.id = id;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    public EspecialidadDTO getEspecialidad() { return especialidad; }
    public void setEspecialidad(EspecialidadDTO especialidad) { this.especialidad = especialidad; }

    public Set<ObraSocialDTO> getObrasSocialesAtendidas() { return obrasSocialesAtendidas; }
    public void setObrasSocialesAtendidas(Set<ObraSocialDTO> obrasSocialesAtendidas) { this.obrasSocialesAtendidas = obrasSocialesAtendidas; }

    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }
}