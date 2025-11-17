package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.model.EspecialidadRanking;
import com.poliemergencias.demo.model.TipoEstudio;
import com.poliemergencias.demo.repository.EspecialidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Transactional
    public List<EspecialidadRanking> especialidadMasPedida(String fechaInicio, String fechaFinal){
        return especialidadRepository.especialidadesMasPedidas(fechaInicio,fechaFinal);
    }

    @Transactional
    public List<Especialidad> getEspecialidad(){
        return especialidadRepository.findAll();
    }
}
