package com.poliemergencias.demo.dto;

public class RegistrationDTO {
    private String username;
    private String password;
    private String role; // Default role
    private int contactoEmergencia;

    public RegistrationDTO(String username, String password, String role, int contactoEmergencia) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.contactoEmergencia = contactoEmergencia;
    }

    public RegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(int contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }
}
