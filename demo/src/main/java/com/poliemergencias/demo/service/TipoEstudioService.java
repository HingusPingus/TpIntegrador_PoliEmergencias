package com.poliemergencias.demo.service;

import com.poliemergencias.demo.dto.EspecialidadDTO;
import com.poliemergencias.demo.dto.TipoEstudioDTO;
import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.model.TipoEstudio;
import com.poliemergencias.demo.repository.EspecialidadRepository;
import com.poliemergencias.demo.repository.TipoEstudioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEstudioService {
    @Autowired
    private TipoEstudioRepository tipoEstudioRepository;

    @Transactional
    public TipoEstudio cargarTipoEstudio(TipoEstudioDTO tipoEstudioDTO){
        TipoEstudio tipoEstudio =new TipoEstudio();
        tipoEstudio.setNombre(tipoEstudioDTO.getNombre());
        return tipoEstudioRepository.save(tipoEstudio);
    }
}
