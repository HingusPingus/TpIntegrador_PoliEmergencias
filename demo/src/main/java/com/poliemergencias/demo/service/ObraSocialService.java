package com.poliemergencias.demo.service;

import com.poliemergencias.demo.model.ObraSocial;
import com.poliemergencias.demo.repository.ObraSocialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraSocialService {
    @Autowired
    private ObraSocialRepository obraSocialRepository;

    @Transactional
    public List<ObraSocial> getObrasSociales(){
        return obraSocialRepository.findAll();
    }
}
