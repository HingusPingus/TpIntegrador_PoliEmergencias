package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.SedeDTO;
import com.poliemergencias.demo.model.Sede;
import com.poliemergencias.demo.repository.SedeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;
    @Transactional
    public Sede cargarSede(SedeDTO sedeDTO){
        if(sedeRepository.findByDireccion(sedeDTO.getDireccion()).isPresent()){
            throw new RuntimeException("Ya hay una sede en esa direccion");
        }
        Sede sede=new Sede();
        sede.setDireccion(sedeDTO.getDireccion());
        sede.setNombre(sedeDTO.getNombre());

        return sedeRepository.save(sede);
    }
    @Transactional
    public List<Sede> getSedes(){
        return sedeRepository.findAll();
    }
}
