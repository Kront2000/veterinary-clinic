package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.*;
import com.veterinary_clinic.veterinary_clinic.util.AddImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Service
public class ProceduresService {
    private final ProceduresRepository dishRepository;


    public List<ProceduresDto> findAll(){
        return dishRepository.findAll().stream().map(procedures -> ProceduresDto.builder()
                .id(procedures.getId())
                .build()
        ).toList();
    }

}
