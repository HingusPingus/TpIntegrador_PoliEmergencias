package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Long> {

}
