package com.veterinary_clinic.veterinary_clinic.procedures;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProceduresRepository extends JpaRepository<Procedures, Long> {
}
