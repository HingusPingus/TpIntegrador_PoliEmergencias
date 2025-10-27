package com.poliemergencias.demo.dto;

public class PacienteDTO {
    private Long id;
    private ObraSocialDTO obraSocial;
    private UserDTO user;

    public PacienteDTO() {}

    public PacienteDTO(Long id, ObraSocialDTO obraSocial) {
        this.id = id;
        this.obraSocial = obraSocial;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ObraSocialDTO getObraSocial() { return obraSocial; }
    public void setObraSocial(ObraSocialDTO obraSocial) { this.obraSocial = obraSocial; }

    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }
}