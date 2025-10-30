package com.poliemergencias.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "turno")
public class Turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private Sede sede;


    @ManyToOne
    private Doctor doctor;

    @OneToOne(mappedBy = "turno", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Estudio estudio;

    @OneToOne(mappedBy = "turno", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Clinica clinica;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado; // RESERVADO, CANCELADO, FINALIZADO


    // getters/setters
    public enum EstadoTurno { RESERVADO, CANCELADO, FINALIZADO }

    public Turno(Long id, LocalDate fechaPedido, LocalDate fechaTurno, LocalTime horario, LocalTime duracion, Sede sede, Doctor doctor, Especialidad especialidad, EstadoTurno estado, String indicacionesProfesional) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaTurno = fechaTurno;
        this.horario = horario;
        this.duracion = duracion;
        this.sede = sede;
        this.doctor = doctor;
        this.estado = estado;
    }

    public Turno() {
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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }



    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
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
