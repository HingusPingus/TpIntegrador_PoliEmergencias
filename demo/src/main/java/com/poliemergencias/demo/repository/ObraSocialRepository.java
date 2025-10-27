package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.ObraSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ObraSocialRepository extends JpaRepository<ObraSocial,Long> {
}
