package com.veterinary_clinic.veterinary_clinic.procedures.repository;

import com.veterinary_clinic.veterinary_clinic.procedures.model.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProceduresRepository extends JpaRepository<Procedures, Long> {
}
