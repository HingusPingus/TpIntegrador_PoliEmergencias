package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.PacienteRegistrationDTO;
import com.poliemergencias.demo.model.Paciente;
import com.poliemergencias.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/register")
    public ResponseEntity<?> registerPaciente(@RequestBody PacienteRegistrationDTO registrationDTO) {
        try {
            Paciente paciente = pacienteService.registerPaciente(registrationDTO);
            return ResponseEntity.ok("Paciente registered successfully with ID: " + paciente.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}