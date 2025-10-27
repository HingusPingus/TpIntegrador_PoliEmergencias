package com.poliemergencias.demo.dto;

public class PacienteRegistrationDTO {
    private String username;
    private String password;
    private String role = "PACIENTE"; // Default role
    private int contactoEmergencia;
    private Long obraSocialId;

    // Constructors
    public PacienteRegistrationDTO() {}

    public PacienteRegistrationDTO(String username, String password, Long obraSocialId,int contactoEmergencia) {
        this.username = username;
        this.password = password;
        this.obraSocialId = obraSocialId;
        this.contactoEmergencia=contactoEmergencia;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Long getObraSocialId() { return obraSocialId; }
    public void setObraSocialId(Long obraSocialId) { this.obraSocialId = obraSocialId; }

    public int getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(int contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }
}
