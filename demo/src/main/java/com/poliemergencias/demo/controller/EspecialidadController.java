package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.model.EspecialidadRanking;
import com.poliemergencias.demo.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;
    @GetMapping("/ranking")
    public ResponseEntity<?> rankingEspecialidades(@RequestParam String fechaInicio,@RequestParam String fechaFin){
        try {
            List<EspecialidadRanking> lista = especialidadService.especialidadMasPedida(fechaInicio,fechaFin);
            if (!lista.isEmpty()) {
                return ResponseEntity.ok(lista);
            }
            throw new RuntimeException("No hubieron turnos en ese rango");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
