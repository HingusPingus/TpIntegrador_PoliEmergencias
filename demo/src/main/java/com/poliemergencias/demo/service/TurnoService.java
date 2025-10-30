package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.Clinica;
import com.poliemergencias.demo.model.Estudio;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private ClinicaRepository clinicaRepository;
    @Autowired
    private EstudioRepository estudioRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SedeRepository sedeRepository;
    @Autowired
    private TipoEstudioRepository tipoEstudioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Transactional
    public Turno cargarTurno(TurnoDTO turnoDTO, Long idUsuario){
        Turno turno=new Turno();
        turno.setFechaTurno(turnoDTO.getFecha().toLocalDate());
        if(doctorRepository.existsById(turnoDTO.getId_doctor()))
            turno.setIdDoctor(turnoDTO.getId_doctor());
        else throw new RuntimeException("Ese doctor no existe");
        if(sedeRepository.existsById(turnoDTO.getSede()))
            turno.setIdSede(turnoDTO.getSede());
        else throw new RuntimeException("Esa sede no existe");
        if (pacienteRepository.existsById(idUsuario))
            turno.setIdCliente(idUsuario);
        else throw new RuntimeException("Ese usuario no existe");
        turno.setFechaPedido(LocalDate.now());
        turno.setIdEstado(1L);
        turno.setHorario(turnoDTO.getFecha().toLocalTime());
        Turno savedTurno=turnoRepository.save(turno);
        saveClinicaOrEstudio(turnoDTO,savedTurno);
        return savedTurno;
    }
    private void saveClinicaOrEstudio(TurnoDTO turnoDTO, Turno savedTurno){
        if(turnoDTO.isClinica()){
            Clinica clinica=new Clinica();
            clinica.setTurno(savedTurno);
            clinicaRepository.save(clinica);
        }
        else{
            Estudio estudio=new Estudio();
            if (tipoEstudioRepository.existsById(turnoDTO.getIdEstudio()))
                estudio.setTipo_estudio_id(turnoDTO.getIdEstudio());
            else throw new RuntimeException("Ese tipo de estudio no existe");
            estudio.setTurno(savedTurno);
            estudioRepository.save(estudio);
        }
    }
}
