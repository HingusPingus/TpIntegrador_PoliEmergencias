package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica,Long> {
}
