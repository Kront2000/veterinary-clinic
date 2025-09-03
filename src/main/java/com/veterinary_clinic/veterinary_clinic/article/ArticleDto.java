package com.veterinary_clinic.veterinary_clinic.article;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ArticleDto(
        //TODO message for NotBlank
        Long id,
        @NotBlank()
        String name,
        String description,
        String content,
        String image_path,
        boolean on_main,
        MultipartFile image

) {
}
