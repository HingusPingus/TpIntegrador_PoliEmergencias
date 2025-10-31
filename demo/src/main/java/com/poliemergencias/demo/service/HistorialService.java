package com.poliemergencias.demo.service;

import com.poliemergencias.demo.model.RegistroMedico;
import com.poliemergencias.demo.repository.RegistroRepository;
import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {
    @Autowired
    private RegistroRepository registroRepository;

    @Transactional
    public List<RegistroMedico> mostrarHistorial(Long id){
        return registroRepository.findByIdClienteId(id);
    }
}
