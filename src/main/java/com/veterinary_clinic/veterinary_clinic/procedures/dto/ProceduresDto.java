package com.veterinary_clinic.veterinary_clinic.procedures.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record ProceduresDto(
        //TODO message for NotBlank
        Long id,
        @NotBlank()
        String name,
        String description,
        String image_path,
        Long price
) {
}
