package com.poliemergencias.demo.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.poliemergencias.demo.model.RegistroMedico;
import com.poliemergencias.demo.model.Turno;
import com.poliemergencias.demo.service.HistorialService;
import com.poliemergencias.demo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes/{id}")
public class PacienteController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private HistorialService historialService;

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorial(@PathVariable Long id) {
        try {
            List<RegistroMedico> lista = historialService.mostrarHistorial(id);
            if (!lista.isEmpty()) {
                return ResponseEntity.ok(lista);
            }
            throw new RuntimeException("Este cliente no tiene historial");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/turnos/historial")
    public ResponseEntity<?> buscarTurnos(@PathVariable Long id){
        try {
            List<Turno> lista = turnoService.buscarPorCliente(id);
            if (!lista.isEmpty()) {
                return ResponseEntity.ok(lista);
            }
            throw new RuntimeException("Este cliente no tiene historial");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

