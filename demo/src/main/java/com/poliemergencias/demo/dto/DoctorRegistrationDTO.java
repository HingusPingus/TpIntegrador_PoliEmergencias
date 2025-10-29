package com.poliemergencias.demo.dto;

public class DoctorRegistrationDTO extends RegistrationDTO{

    private Long idEspecialidad;
    private int telefono;
    private String imagen;

    public DoctorRegistrationDTO() {
    }

    public DoctorRegistrationDTO(String username, String password, int contactoEmergencia, Long idEspecialidad, int telefono, String imagen) {
        String rol="DOCTOR";
        super(username,password,rol,contactoEmergencia);
        this.idEspecialidad = idEspecialidad;
        this.telefono = telefono;
        this.imagen = imagen;
        this.setRole("DOCTOR");
    }



    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
