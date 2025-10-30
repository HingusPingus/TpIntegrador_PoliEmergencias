package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.PacienteRegistrationDTO;
import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.Paciente;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/usuarios")
    public ResponseEntity<?> registerPaciente(@RequestBody TurnoDTO turnoDTO, @RequestParam Long idUsuario) {
        try {
            Turno turno = turnoService.cargarTurno(turnoDTO, idUsuario);
            return ResponseEntity.ok("Turno registered successfully with ID: " + turno.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/asd")
    public ResponseEntity<?> registerPacssiente(@RequestBody TurnoDTO turnoDTO, @RequestParam Long idUsuario) {
        try {

            return ResponseEntity.ok("Turno registered successfully with ID: " );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
