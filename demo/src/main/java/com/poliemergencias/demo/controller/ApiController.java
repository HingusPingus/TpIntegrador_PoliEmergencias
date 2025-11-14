package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.LoginDTO;
import com.poliemergencias.demo.dto.PacienteRegistrationDTO;
import com.poliemergencias.demo.model.Doctor;
import com.poliemergencias.demo.model.Paciente;
import com.poliemergencias.demo.model.User;
import com.poliemergencias.demo.service.PacienteService;
import com.poliemergencias.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private UserService userService;

    @PostMapping("/usuarios")
    public ResponseEntity<?> registerPaciente(@RequestBody PacienteRegistrationDTO registrationDTO) {
        try {
            registrationDTO.setRole("PACIENTE");
            Paciente paciente = pacienteService.registerPaciente(registrationDTO);
            return ResponseEntity.ok("Paciente registered successfully with ID: " + paciente.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            Optional<User> user = userService.logIn(loginDTO);
            if(user.isPresent()) {
                return ResponseEntity.ok(user);
            }
            else throw new RuntimeException("Usuario o contraseña incorrectos");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/emergencias")
    public ResponseEntity<?> getEmergencias(@RequestParam Long userId){
        try{
            return ResponseEntity.ok(userService.getEmergencia(userId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
