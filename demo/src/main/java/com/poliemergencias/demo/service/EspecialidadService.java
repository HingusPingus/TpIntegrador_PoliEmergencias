package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.repository.EspecialidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public Especialidad cargarEspecialidad(EspecialidadDTO especialidadDTO){
        Especialidad especialidad =new Especialidad();
        especialidad.setNombre(especialidadDTO.getNombre());
        return especialidadRepository.save(especialidad);
    }
}
