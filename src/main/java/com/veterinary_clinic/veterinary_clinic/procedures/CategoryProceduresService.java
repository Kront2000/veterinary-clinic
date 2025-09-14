package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.*;
import com.veterinary_clinic.veterinary_clinic.util.AddImageService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CategoryProceduresService {
    private final CategoryProceduresRepository categoryProceduresRepository;
    private final ProceduresRepository proceduresRepository;
    private final AddImageService addImageService;

    public List<CategoryProceduresDto> findAll(){
        return categoryProceduresRepository.findAll().stream()
                .map(category -> CategoryProceduresDto.builder()
                        .id(category.getId())
                        .description(category.getDescription())
                        .image_path(category.getImage_path())
                        .name(category.getName())
                        .build())
                .toList();
    }
    public void deleteCategory(Long id){

        categoryProceduresRepository.deleteById(id);
    }

    public CategoryProcedures save(CategoryProceduresDto categoryProceduresDto) throws IOException {
        CategoryProcedures newCategory = CategoryProcedures.builder()
                .name(categoryProceduresDto.name())
                .description(categoryProceduresDto.description())
                .image_path(addImageService.addImageCloudinary(categoryProceduresDto.image()))
                .build();
        return categoryProceduresRepository.save(newCategory);
    }

    @Cacheable("menu")
    public List<CategoryWithProceduresDto>  getMenu(){
        // Получаем все категории
        List<CategoryProcedures> categories = categoryProceduresRepository.findAll();

// Получаем все блюда одним запросом
        List<ProceduresDto> proceduresDtoList = proceduresRepository.findAll().stream().map(procedures -> ProceduresDto.builder()
                .id(procedures.getId())
                .name(procedures.getName())
                .category_id(procedures.getCategory().getId())
                .category_name(procedures.getCategory().getName())
                .price(procedures.getPrice())
                .on_main(procedures.isOn_main()).build()
        ).toList();;

// Группируем блюда по категории
        List<CategoryWithProceduresDto> result = new ArrayList<>();
        Map<CategoryProcedures, List<ProceduresDto>> proceduresByCategory = new HashMap<>();
         for (CategoryProcedures category : categories){
             List<ProceduresDto> listOfProcedures = new ArrayList<>();
            for (ProceduresDto proceduresDto : proceduresDtoList){
                if (category.getName().equals(proceduresDto.category_name())){
                    listOfProcedures.add(proceduresDto);
                }
            }
            result.add(CategoryWithProceduresDto.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .image_path(category.getImage_path())
                            .description(category.getDescription())
                            .procedures(listOfProcedures)
                    .build());
        }
        return result;

    }

    public CategoryProcedures update(CategoryProceduresDto categoryProceduresDto) throws IOException {
        CategoryProcedures categoryProcedures = categoryProceduresRepository.findById(categoryProceduresDto.id()).orElseThrow(RuntimeException::new);
        categoryProcedures.setDescription(categoryProceduresDto.description());
        categoryProcedures.setName(categoryProcedures.getName());
        if (categoryProceduresDto.image() != null) {
            categoryProcedures.setImage_path(addImageService.addImageCloudinary(categoryProceduresDto.image()));
        }
        return categoryProceduresRepository.save(categoryProcedures);
    }
}
