package com.poliemergencias.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable

public class RegistroPK {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, unique = false, updatable = false, nullable = false,name = "cliente_usuario_id_usuario")
    private Long clienteId;

    @Column(insertable = false, unique = false, updatable = false, nullable = false,name = "fecha_turno")
    private LocalDate fecha;

    public RegistroPK(Long clienteId, LocalDate fecha) {
        this.clienteId = clienteId;
        this.fecha = fecha;
    }

    public RegistroPK() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
