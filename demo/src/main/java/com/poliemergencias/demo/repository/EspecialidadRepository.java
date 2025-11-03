package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.Especialidad;
import com.poliemergencias.demo.dto.EspecialidadRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad,Long> {

    @Query(value = "CALL especialidad_con_mayor_demanda(:fecha_start, :fecha_end)", nativeQuery = true)
    List<EspecialidadRanking> especialidadesMasPedidas(@Param("fecha_start") String fechaStart,
                                                       @Param("fecha_end") String fechaEnd);
}
