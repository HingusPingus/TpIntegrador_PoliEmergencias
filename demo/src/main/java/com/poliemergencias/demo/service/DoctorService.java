package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.*;
import com.poliemergencias.demo.repository.DoctorRepository;
import com.poliemergencias.demo.repository.EspecialidadRepository;
import com.poliemergencias.demo.repository.ObraSocialRepository;
import com.poliemergencias.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ObraSocialRepository obraSocialRepository;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Transactional
    public Doctor registerDoctor(DoctorRegistrationDTO registrationDTO) {
        User savedUser = userService.registerUser(registrationDTO);
        Doctor doctor = new Doctor();
        doctor.setUser(savedUser);
        doctor.setTelefono(registrationDTO.getTelefono());
        doctor.setImagen(registrationDTO.getImagen());
        if (registrationDTO.getIdEspecialidad() != null) {
            Especialidad especialidad = especialidadRepository.findById(registrationDTO.getIdEspecialidad())
                    .orElseThrow(() -> new RuntimeException("Especialidad not found"));
            doctor.setEspecialidades(especialidad);
        }
        return doctorRepository.save(doctor);
    }

    @Transactional
    public List<Doctor> listByObraSocial(Long obraSocialId){
        return doctorRepository.findByObrasSocialesAtendidasId(obraSocialId);

    }
    @Transactional
    public Doctor listByObraSocialEsp(Long obraSocialId,Long especialidad, Long sede,String fecha,String hora){
        List<Doctor> doctoresPosibles=doctorRepository.findByObrasSocialesAtendidasIdAndEspecialidadesIdAndHospitalesId(obraSocialId,especialidad,sede);
        for(Doctor d :doctoresPosibles){
            if(!doctorHasTurno(fecha,hora,d)){
                return d;
            }
        }
        throw new RuntimeException("No hay doctores disponibles");
    }

    public boolean checkDoctor(TurnoDTO turnoDTO, Long idUsuario) {
        Doctor doctor = doctorRepository.findById(turnoDTO.getId_doctor()).get();
        if (doctorHasTurno(turnoDTO,doctor)){
            return false;
        }
        if(doctorNotAttendsObraSocial(doctor,idUsuario)){
            return false;
        }
        if(doctorHasNotEspecialidad(turnoDTO,doctor)){
            return false;
        }
        return true;
    }

    public boolean doctorHasTurno(TurnoDTO turnoDTO, Doctor doctor){

        for (Turno t : doctor.getTurnos()) {
            if (turnoDTO.getFecha().equals(t.getFechaTurno()) && turnoDTO.getHorario().getHour() == t.getHorario().getHour()) {
                return true;
            }
        }
        return false;
    }

    public boolean doctorHasTurno(String fecha,String hora, Doctor doctor){
        for (Turno t : doctor.getTurnos()) {
            if (LocalDate.parse(fecha).equals(t.getFechaTurno()) && LocalTime.parse(hora).getHour() == t.getHorario().getHour()) {
                return true;
            }
        }
        return false;
    }
    public boolean doctorNotAttendsObraSocial(Doctor doctor,Long idUsuario){
        Paciente paciente = pacienteRepository.findById(idUsuario).get();
        for (Doctor d : doctorRepository.findByObrasSocialesAtendidasId(paciente.getObraSocial().getId())) {
            if(d.getId().equals(doctor.getId())){
                return false;
            }
        }
        return true;
    }
    public boolean doctorHasNotEspecialidad(TurnoDTO turnoDTO, Doctor doctor){
        for (Doctor d : doctorRepository.findByEspecialidades_id(turnoDTO.getIdEspecialidad())) {
            if(d.getId().equals(doctor.getId())){
                return false;
            }
        }
        return true;
    }
}
