package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.CategoryProduct;
import com.veterinary_clinic.veterinary_clinic.product.CategoryProductDto;
import com.veterinary_clinic.veterinary_clinic.product.CategoryProductService;
import com.veterinary_clinic.veterinary_clinic.product.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categoryProcedures")
public class CategoryProceduresController {

    private final CategoryProceduresService service;


    @GetMapping
    public List<CategoryProceduresDto> findAll(){
        return service.findAll();
    }
    @PostMapping
    public CategoryProcedures save(@RequestParam("name") String name,
                                   @RequestParam("description") String description,
                                   @RequestPart(value = "image", required = false)MultipartFile image) throws IOException {
        CategoryProceduresDto categoryDto = CategoryProceduresDto.builder()
                .name(name)
                .image(image)

                .description(description)
                .build();
        System.out.println("Диш дто: " + categoryDto);

        return service.save(categoryDto);
    }
    @PutMapping
    @CacheEvict(value = "menu", allEntries = true)
    public CategoryProcedures update(@RequestParam("name") String name,
                                     @RequestParam("id") Long id,
                                   @RequestParam("description") String description,
                                   @RequestPart(value = "image", required = false)MultipartFile image) throws IOException {
        CategoryProceduresDto categoryDto = CategoryProceduresDto.builder()
                .id(id)
                .name(name)
                .image(image)
                .description(description)
                .build();
        System.out.println("Диш дто: " + categoryDto);

        return service.update(categoryDto);
    }

    @DeleteMapping
    public void deleteDish(@RequestParam("id") Long id){
        service.deleteCategory(id);
    }
}
