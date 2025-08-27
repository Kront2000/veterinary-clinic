package com.veterinary_clinic.veterinary_clinic.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ArticleDto(
        //TODO message for NotBlank
        Long id,
        @NotBlank()
        String name,
        String description,
        String text,
        String image_path

) {
}
