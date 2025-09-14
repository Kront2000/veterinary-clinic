package com.veterinary_clinic.veterinary_clinic.procedures;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category_procedure")
public class CategoryProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private String image_path;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Procedures> procedures = new ArrayList<>();
}