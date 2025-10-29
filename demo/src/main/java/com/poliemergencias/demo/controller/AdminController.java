package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.DoctorRegistrationDTO;
import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.dto.SedeDTO;
import com.poliemergencias.demo.dto.TipoEstudioDTO;
import com.poliemergencias.demo.model.*;
import com.poliemergencias.demo.repository.UserRepository;
import com.poliemergencias.demo.service.DoctorService;
import com.poliemergencias.demo.service.EspecialidadService;
import com.poliemergencias.demo.service.SedeService;
import com.poliemergencias.demo.service.TipoEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    private UserRepository userRepository;
    @PostMapping("/cargar-doctores")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegistrationDTO registrationDTO, @RequestParam Long idAdmin) {
        try{
            registrationDTO.setRole("DOCTOR");
            Optional<User> user=userRepository.findById(idAdmin);
            if(user.isPresent()&&user.get().getRole().equals("ADMIN")) {
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
            Optional<User> user=userRepository.findById(idAdmin);
            if(user.isPresent()&&user.get().getRole().equals("ADMIN")) {
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
            Optional<User> user=userRepository.findById(idAdmin);
            if(user.isPresent()&&user.get().getRole().equals("ADMIN")) {
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
            Optional<User> user=userRepository.findById(idAdmin);
            if(user.isPresent()&&user.get().getRole().equals("ADMIN")) {
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
    @PostMapping("/hacer-admin")
    public ResponseEntity<?> hacerAdmin(@RequestBody Long idCliente,@RequestParam Long idAdmin){
        try {
            Optional<User> user = userRepository.findById(idAdmin);
            if (user.isPresent() && user.get().getRole().equals("ADMIN")) {
                Optional<User> userCli=userRepository.findById(idCliente);
                if (userCli.isPresent()) {
                    User userCLient=userCli.get();
                    userCLient.setRole("ADMIN");
                    userRepository.save(userCLient);
                    return ResponseEntity.ok("El usuario de id "+idCliente+" ahora es admin");
                }
                throw new RuntimeException("Ese usuario no existe");
            } else {
                throw new RuntimeException("No tiene permiso para ejecutar esta accion");
            }
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}