package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.repository.TurnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    @Transactional

    public Turno cargarTurno(TurnoDTO turnoDTO, Long idUsuario){
        Turno turno=new Turno();
        turno.setFechaTurno(turnoDTO.getFechaTurno());
        turno.set(turnoDTO.getDoctor());
        turno.setFechaTurno(turnoDTO.getFechaTurno());
        turno.setFechaTurno(turnoDTO.getFechaTurno());
        turno.setFechaTurno(turnoDTO.getFechaTurno());
    }
}
