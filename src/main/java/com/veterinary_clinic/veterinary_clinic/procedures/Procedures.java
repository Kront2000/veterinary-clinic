package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.CategoryProduct;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@ToString(exclude = "category")
@Builder
@Entity
@Table(name = "procedures")
public class Procedures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private boolean on_main;
    @ManyToOne
    private CategoryProcedures category;
    private Long price;
}
