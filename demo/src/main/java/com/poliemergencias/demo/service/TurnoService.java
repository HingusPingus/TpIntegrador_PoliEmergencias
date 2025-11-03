package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.dto.TurnoFinDTO;
import com.poliemergencias.demo.model.*;
import com.poliemergencias.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public Turno cargarTurno(TurnoDTO turnoDTO, Long idUsuario){
        Turno turno=new Turno();
        if (pacienteRepository.existsById(idUsuario))
            turno.setIdCliente(idUsuario);
        else throw new RuntimeException("Ese usuario no existe");
        if (doctorRepository.existsById(turnoDTO.getId_doctor()))
            turno.setIdDoctor(turnoDTO.getId_doctor());
        else throw new RuntimeException("Ese doctor no existe");
        if(checkDoctor(turnoDTO,idUsuario)) {
            turno.setFechaTurno(turnoDTO.getFecha());
            if (sedeRepository.existsById(turnoDTO.getSede()))
                turno.setIdSede(turnoDTO.getSede());
            else throw new RuntimeException("Esa sede no existe");
            turno.setFechaPedido(LocalDate.now());
            turno.setIdEstado(1L);
            turno.setHorario(turnoDTO.getHorario());
            Turno savedTurno = turnoRepository.save(turno);
            saveClinicaOrEstudio(turnoDTO, savedTurno);
            return savedTurno;
        }else throw new RuntimeException("El doctor seleccionado no soporta su obra social o no esta disponible");
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
    @Transactional
    public List<Turno> buscarPorCliente(Long idCliente){
        return turnoRepository.findByIdCliente(idCliente);
    }
    public boolean checkDoctor(TurnoDTO turnoDTO, Long idUsuario) {
        Doctor doctor = doctorRepository.findById(turnoDTO.getId_doctor()).get();
        for (Turno t : doctor.getTurnos()) {
            if (turnoDTO.getFecha().equals(t.getFechaTurno()) && turnoDTO.getHorario().getHour() == t.getHorario().getHour()) {
                return false;
            }
        }
        Paciente paciente = pacienteRepository.findById(idUsuario).get();

        for (Doctor d : doctorRepository.findByObrasSocialesAtendidasId(paciente.getObraSocial().getId())) {
            if(d.getId().equals(doctor.getId())){
                return true;
            }

        }
        return false;
    }

    public Turno finalizarTurno(TurnoFinDTO turnoDTO, Long userId, Long turnoId){
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()&&user.get().getRole().equals("DOCTOR")) {
            Optional<Turno> turnoOp = turnoRepository.findById(turnoId);
            if (turnoOp.isPresent()&&turnoOp.get().getIdDoctor().equals(userId)) {
                Turno turno = turnoOp.get();
                turno.setDuracion(turnoDTO.getDuracion());
                turno.setInfo(turnoDTO.getInforme());
                return turnoRepository.save(turno);
            } else {
                if(turnoOp.isEmpty()) throw new RuntimeException("No existe ese turno");
                else throw new RuntimeException("Usted no tiene permiso para acceder a este turno");
            }
        }
        else throw new RuntimeException("No tiene permiso para hacer eso");
    }
}
