package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.RegistroMedico;
import com.poliemergencias.demo.model.RegistroPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegistroRepository extends JpaRepository<RegistroMedico, RegistroPK> {

     List<RegistroMedico> findByIdClienteId(Long clienteId);


}
