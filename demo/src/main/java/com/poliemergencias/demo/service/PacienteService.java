package com.poliemergencias.demo.service;

import com.poliemergencias.demo.model.*;
import com.poliemergencias.demo.repository.*;
import com.poliemergencias.demo.dto.PacienteRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ObraSocialRepository obraSocialRepository;

    private UserService userService;

    @Transactional
    public Paciente registerPaciente(PacienteRegistrationDTO registrationDTO) {
        // Check if username already exists
        User savedUser=userService.registerUser(registrationDTO);

        // Create Paciente entity
        Paciente paciente = new Paciente();
        paciente.setUser(savedUser);

        // Set ObraSocial if provided
        if (registrationDTO.getObraSocialId() != null) {
            ObraSocial obraSocial = obraSocialRepository.findById(registrationDTO.getObraSocialId())
                    .orElseThrow(() -> new RuntimeException("ObraSocial not found"));
            paciente.setObraSocial(obraSocial);
        }

        // Save Paciente
        return pacienteRepository.save(paciente);
    }
}