package com.poliemergencias.demo.dto;

public class PacienteRegistrationDTO extends RegistrationDTO{
    private Long obraSocialId;

    // Constructors
    public PacienteRegistrationDTO() {}

    public PacienteRegistrationDTO(String username, String password, Long obraSocialId,int contactoEmergencia) {
        super(username,password,"PACIENTE",contactoEmergencia);
        this.obraSocialId = obraSocialId;

    }



    public Long getObraSocialId() { return obraSocialId; }
    public void setObraSocialId(Long obraSocialId) { this.obraSocialId = obraSocialId; }

}
