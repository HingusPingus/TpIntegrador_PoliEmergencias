package com.poliemergencias.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private Long id;
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;
    @Column(name="fecha_turno")
    private LocalDate fechaTurno;
    @Column(name = "horario")
    private LocalTime horario;
    @Column(name="duracion")
    private LocalTime duracion;
    @Column(name = "medico_usuario_id_usuario")
    private Long idDoctor;
    @Column(name = "hospital_id_hospital")
    private Long idSede;
    @Column(name = "estado_id_estado")
    private Long idEstado;
    @Column(name = "cliente_usuario_id_usuario")
    private Long idCliente;
    @Column(name = "info")
    private String info;

    @OneToOne(mappedBy = "turno", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Estudio estudio;

    @OneToOne(mappedBy = "turno", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    
    private Clinica clinica;

    public Turno(Long id, LocalDate fechaPedido, LocalDate fechaTurno, LocalTime horario, LocalTime duracion,   Especialidad especialidad, String indicacionesProfesional) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaTurno = fechaTurno;
        this.horario = horario;
        this.duracion = duracion;



    }

    public Turno() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }



    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Long getIdSede() {
        return idSede;
    }

    public void setIdSede(Long idSede) {
        this.idSede = idSede;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
}
