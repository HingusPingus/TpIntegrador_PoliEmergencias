package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long> {

    Optional<Sede> findByDireccion(String direccion);
}
