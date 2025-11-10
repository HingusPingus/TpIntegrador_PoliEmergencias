package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.PacienteRegistrationDTO;
import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.dto.TurnoFinDTO;
import com.poliemergencias.demo.model.Paciente;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/usuarios")
    public ResponseEntity<?> registerTurno(@RequestBody TurnoDTO turnoDTO, @RequestParam Long userId) {
        try {
            Turno turno = turnoService.cargarTurno(turnoDTO, userId);
            return ResponseEntity.ok("Turno registered successfully with ID: " + turno.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<?> finTurno(@RequestBody TurnoFinDTO turnoDTO, @RequestParam Long userId, @PathVariable Long id) {
        try {
            Turno turno = turnoService.finalizarTurno(turnoDTO, userId,id);
            return ResponseEntity.ok("Turno finalized successfully with ID: " + turno.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
