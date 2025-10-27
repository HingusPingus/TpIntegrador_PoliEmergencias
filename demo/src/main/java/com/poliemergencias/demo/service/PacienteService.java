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

    @Transactional
    public Paciente registerPaciente(PacienteRegistrationDTO registrationDTO) {
        // Check if username already exists
        if (userRepository.findByName(registrationDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Create User entity
        User user = new User();
        user.setName(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword()); // In production, encrypt this!
        user.setRole(registrationDTO.getRole());
        user.setContactoEmergencia(registrationDTO.getContactoEmergencia());

        // Save User first
        User savedUser = userRepository.save(user);

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