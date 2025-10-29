package com.poliemergencias.demo.dto;

public class PacienteRegistrationDTO extends RegistrationDTO{
    private Long obraSocialId;

    // Constructors
    public PacienteRegistrationDTO() {}

    public PacienteRegistrationDTO(String username, String password, Long obraSocialId,int contactoEmergencia) {
        String rol="PACIENTE";
        super(username,password,rol,contactoEmergencia);
        this.obraSocialId = obraSocialId;
        this.setRole("PACIENTE");

    }



    public Long getObraSocialId() { return obraSocialId; }
    public void setObraSocialId(Long obraSocialId) { this.obraSocialId = obraSocialId; }

}
