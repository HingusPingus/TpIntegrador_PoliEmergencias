package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.Clinica;
import com.poliemergencias.demo.model.Estudio;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.repository.ClinicaRepository;
import com.poliemergencias.demo.repository.EstudioRepository;
import com.poliemergencias.demo.repository.TurnoRepository;
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
    @Transactional
    public Turno cargarTurno(TurnoDTO turnoDTO, Long idUsuario){
        Turno turno=new Turno();
        turno.setFechaTurno(turnoDTO.getFecha());
        turno.setIdDoctor(turnoDTO.getId_doctor());
        turno.setFechaPedido(LocalDate.now());
        turno.setIdEstado(1L);
        turno.setIdSede(turnoDTO.getSede());
        turno.setHorario(turnoDTO.getHorario());
        turno.setIdCliente(idUsuario);
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
            estudio.setTipo_estudio_id(turnoDTO.getIdEstudio());
            estudio.setTurno(savedTurno);
            estudioRepository.save(estudio);
        }
    }
}
