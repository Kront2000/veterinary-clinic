package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProceduresRepository extends JpaRepository<CategoryProcedures, Long> {
    Optional<CategoryProcedures> findByName(String name);
}
