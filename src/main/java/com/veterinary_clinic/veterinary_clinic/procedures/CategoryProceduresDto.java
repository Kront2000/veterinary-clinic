package com.veterinary_clinic.veterinary_clinic.procedures;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record CategoryProceduresDto(
        Long id,
        String name,
        String category_name,
        String description,
        String image_path,
        MultipartFile image
) {
}
