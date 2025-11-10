package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.model.Doctor;
import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.model.ObraSocial;
import com.poliemergencias.demo.model.User;
import com.poliemergencias.demo.repository.DoctorRepository;
import com.poliemergencias.demo.repository.EspecialidadRepository;
import com.poliemergencias.demo.repository.ObraSocialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
