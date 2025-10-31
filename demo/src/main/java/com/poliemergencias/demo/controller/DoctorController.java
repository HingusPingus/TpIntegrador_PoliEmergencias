package com.poliemergencias.demo.controller;

import com.poliemergencias.demo.model.Doctor;
import com.poliemergencias.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
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
}
