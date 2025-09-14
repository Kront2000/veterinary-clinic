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
    private final ProceduresRepository proceduresRepository;
    private final CategoryProceduresRepository categoryRepository;
    private final AddImageService addImageService;

    public List<ProceduresDto> findAll(){
        return proceduresRepository.findAll().stream().map(procedures -> ProceduresDto.builder()
                .id(procedures.getId())
                .name(procedures.getName())
                .category_id(procedures.getCategory().getId())
                .category_name(procedures.getCategory().getName())
                .price(procedures.getPrice())
                .on_main(procedures.isOn_main()).build()
        ).toList();
    }
    public Procedures save(ProceduresDto proceduresDto) throws IOException {
        CategoryProcedures category = categoryRepository.findByName(proceduresDto.category_name()).orElse(new CategoryProcedures());
        Procedures newProcedures = Procedures.builder()
                .name(proceduresDto.name())
                .price(proceduresDto.price())
                .category(category)
                .on_main(proceduresDto.on_main())
                .build();
        return proceduresRepository.save(newProcedures);
    }
    public ProceduresDto findById(Long id){
        Procedures procedures = proceduresRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return ProceduresDto.builder()
                .id(procedures.getId())
                .name(procedures.getName())
                .category_id(procedures.getCategory().getId())
                .category_name(procedures.getCategory().getName())
                .on_main(procedures.isOn_main())
                .price(procedures.getPrice()).build();

    }

    public Procedures updateProcedures(ProceduresDto proceduresDto) throws IOException {
        Procedures procedures = proceduresRepository.findById(proceduresDto.id()).orElse(new Procedures());
        CategoryProcedures category = categoryRepository.findByName(proceduresDto.category_name()).orElseThrow(() -> new RuntimeException());
        Procedures newProduct = Procedures.builder()
                .name(proceduresDto.name())
                .price(proceduresDto.price())
                .id(proceduresDto.id())
                .category(category)
                .on_main(proceduresDto.on_main())
                .build();
        return proceduresRepository.save(newProduct);
    }

    public void deleteProcedures(Long id){
        proceduresRepository.deleteById(id);
    }
}
