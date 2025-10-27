package com.poliemergencias.demo.repository;

import com.poliemergencias.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
