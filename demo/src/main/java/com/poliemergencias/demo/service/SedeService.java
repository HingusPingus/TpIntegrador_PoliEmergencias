package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.SedeDTO;
import com.poliemergencias.demo.model.Sede;
import com.poliemergencias.demo.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public Sede cargarSede(SedeDTO sedeDTO){
        if(sedeRepository.findByDireccion(sedeDTO.getDireccion()).isPresent()){
            throw new RuntimeException("Ya hay una sede en esa direccion");
        }
        Sede sede=new Sede();
        sede.setDireccion(sedeDTO.getDireccion());
        sede.setNombre(sedeDTO.getNombre());

        return sedeRepository.save(sede);
    }
}
