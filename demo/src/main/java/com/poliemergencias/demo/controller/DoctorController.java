package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.dto.TurnoDTO;
import com.poliemergencias.demo.model.Doctor;
import com.poliemergencias.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping
    public ResponseEntity<?> listMedicosObraSocial(@RequestParam Long obraSocial){
        try{
            List<Doctor> doctores=doctorService.listByObraSocial(obraSocial);
            if(!doctores.isEmpty()){
                return ResponseEntity.ok(doctores);
            }
            else{
                throw new RuntimeException("Esa obra social no tiene medicos");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/disponible")
    @CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
    public ResponseEntity<?> listMedicosObraSocialEsp(@RequestParam Long obraSocial,@RequestParam Long especialidad,@RequestParam Long sede,@RequestParam String hora,@RequestParam String fecha){
        try{
            Doctor doctor=doctorService.listByObraSocialEsp(obraSocial,especialidad,sede,fecha,hora);
                return ResponseEntity.ok(doctor);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
