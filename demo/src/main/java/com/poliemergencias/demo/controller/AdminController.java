package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.dto.SedeDTO;
import com.poliemergencias.demo.dto.TipoEstudioDTO;
import com.poliemergencias.demo.model.*;
import com.poliemergencias.demo.repository.UserRepository;
import com.poliemergencias.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend

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
    @Autowired
    private UserService userService;
    @PostMapping("/cargar-doctores")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegistrationDTO registrationDTO, @RequestParam Long idAdmin) {
        try{
            registrationDTO.setRole("DOCTOR");
            if(userService.isAdmin(idAdmin)){
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
    public ResponseEntity<?> cargarEspecialidad(@RequestBody EspecialidadDTO especialidadDTO, @RequestParam Long idAdmin) {
        try{
            if(userService.isAdmin(idAdmin)){
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
    public ResponseEntity<?> cargarSede(@RequestBody SedeDTO sedeDTO, @RequestParam Long idAdmin) {
        try{
            if(userService.isAdmin(idAdmin)){
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
    public ResponseEntity<?> cargarEstudios(@RequestBody TipoEstudioDTO tipoEstudioDTO, @RequestParam Long idAdmin) {
        try{
            if(userService.isAdmin(idAdmin)){
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
    @PostMapping("/haceradmin")
    public ResponseEntity<?> hacerAdmin(@RequestBody Long idCliente,@RequestParam Long idAdmin){
        try {
            if(userService.isAdmin(idAdmin)){
                userService.hacerAdmin(idCliente);
                return ResponseEntity.ok("El usuario de id "+idCliente+" ahora es admin");
            }
            else{
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}