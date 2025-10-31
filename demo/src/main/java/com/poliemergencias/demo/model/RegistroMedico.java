package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "historia_medico")
public class RegistroMedico {
    @EmbeddedId
    private RegistroPK id;
    @Column(name = "info")
    private String info;



    public RegistroMedico(Long id, LocalDate fechaTurno, String info, Paciente paciente) {
        this.id = new RegistroPK(id,fechaTurno);
        this.info = info;
    }

    public RegistroMedico(){
        id=new RegistroPK();
    }

    public Long getId() {
        return id.getClienteId();
    }

    public void setId(Long id) {
        this.id.setClienteId(id);
    }

    public LocalDate getFechaTurno() {
        return id.getFecha();
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.id.setFecha(fechaTurno);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
