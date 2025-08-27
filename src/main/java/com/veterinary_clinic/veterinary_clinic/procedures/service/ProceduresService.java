package com.veterinary_clinic.veterinary_clinic.procedures.service;

import com.veterinary_clinic.veterinary_clinic.procedures.dto.ProceduresDto;
import com.veterinary_clinic.veterinary_clinic.procedures.repository.ProceduresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ProceduresService {
    private final ProceduresRepository servicesRepository;

    public List<ProceduresDto> findAll(){
        return servicesRepository.findAll().stream().map(service -> ProceduresDto.builder()
                .id(service.getId())
                .name(service.getName())
                .price(service.getPrice())
                .description(service.getDescription())
                .image_path(service.getImg_path())
                .build()).toList();
    }

}
