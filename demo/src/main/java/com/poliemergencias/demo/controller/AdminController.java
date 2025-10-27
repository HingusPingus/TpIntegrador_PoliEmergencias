package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.dto.SedeDTO;
import com.poliemergencias.demo.dto.TipoEstudioDTO;
import com.poliemergencias.demo.model.Doctor;
import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.model.Sede;
import com.poliemergencias.demo.model.TipoEstudio;
import com.poliemergencias.demo.service.DoctorService;
import com.poliemergencias.demo.service.EspecialidadService;
import com.poliemergencias.demo.service.SedeService;
import com.poliemergencias.demo.service.TipoEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private TipoEstudioService tipoEstudioService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private EspecialidadService especialidadService;
    @Autowired
    private SedeService sedeService;
    @PostMapping("/cargar-doctores")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegistrationDTO registrationDTO, @RequestParam String rol) {
        try{
            if(rol.equals("ADMIN")) {
                Doctor doctor = doctorService.registerDoctor(registrationDTO);
                return ResponseEntity.ok("Doctor registered successfully with ID: " + doctor.getId());
            }
            else{
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cargar-especialidades")
    public ResponseEntity<?> cargarEspecialidad(@RequestBody EspecialidadDTO especialidadDTO, @RequestParam String rol) {
        try{
            if(rol.equals("ADMIN")) {
                Especialidad especialidad= especialidadService.cargarEspecialidad(especialidadDTO);
                return ResponseEntity.ok("Especialidad loaded successfully with ID: "+especialidad.getId() );
            }
            else{
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/hola")
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok("hola");
    }

    @PostMapping("/cargar-sedes")
    public ResponseEntity<?> cargarSede(@RequestBody SedeDTO sedeDTO, @RequestParam String rol) {
        try{
            if(rol.equals("ADMIN")) {
                Sede sede=sedeService.cargarSede(sedeDTO);
                return ResponseEntity.ok("Sede loaded successfully with ID: "+sede.getId() );
            }
            else{
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/cargar-estudios")
    public ResponseEntity<?> cargarEstudios(@RequestBody TipoEstudioDTO tipoEstudioDTO, @RequestParam String rol) {
        try{
            if(rol.equals("ADMIN")) {
                TipoEstudio tipoEstudio=tipoEstudioService.cargarTipoEstudio(tipoEstudioDTO);
                return ResponseEntity.ok("Tipo estudio loaded successfully with ID: "+tipoEstudio.getId() );
            }
            else{
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}