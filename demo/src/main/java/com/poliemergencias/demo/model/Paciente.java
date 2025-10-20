package com.poliemergencias.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_obra_social")
    private ObraSocial obraSocial;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Turno> turnos;

    // getters y setters
    public Paciente(){}

    // constructores, getters y setters...
}
