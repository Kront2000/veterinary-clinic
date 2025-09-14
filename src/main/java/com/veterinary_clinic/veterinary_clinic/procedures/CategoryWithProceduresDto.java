package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryWithProceduresDto(
                                        Long id,
                                        String name,
                                        String description,
                                        String image_path,
                                        List<ProceduresDto> procedures
) {
}
