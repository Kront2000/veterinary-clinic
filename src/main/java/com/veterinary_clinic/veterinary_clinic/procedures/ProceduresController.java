package com.veterinary_clinic.veterinary_clinic.procedures;

import com.veterinary_clinic.veterinary_clinic.product.ProductDto;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/procedures")
public class ProceduresController {
    private final ProceduresService proceduresService;

    private Validator validator;

    private final CategoryProceduresService categoryService;

    @GetMapping
    public List<CategoryWithProceduresDto> getProceduresWithCategory(){
        return categoryService.getMenu();
    }

    @GetMapping("/getAll")
    public List<ProceduresDto> getAllProcedures(){
        return proceduresService.findAll();
    }

    @PostMapping
    @CacheEvict(value = "menu", allEntries = true)
    public void save(@RequestParam("name") String name,
                     @RequestParam("category") String category,
                     @RequestParam("on_main") boolean on_main,
                     @RequestParam("price") Long price) throws IOException {
        ProceduresDto proceduresDto = ProceduresDto.builder()
                .name(name)
                .price(price)
                .category_name(category)
                .on_main(on_main)
                .build();
        System.out.println("Диш дто: " + proceduresDto);

        System.out.println("Сохранённый продукт" + proceduresService.save(proceduresDto));
    }

    @GetMapping("/getById")
    public ProceduresDto getById(@RequestParam("id") String id){
        System.out.println("id - " + id);
        return proceduresService.findById(Long.valueOf(id));
    }

    @PutMapping
    @CacheEvict(value = "menu", allEntries = true)
    public void updateProcedures(@RequestParam("id") Long id, @RequestParam("name") String name,
                           @RequestParam("category") String category,
                           @RequestParam("on_main") boolean on_main,
                           @RequestParam("price") Long price) throws IOException {
        ProceduresDto proceduresDto = ProceduresDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .category_name(category)
                .on_main(on_main)
                .build();

        System.out.println("Диш дто: " + proceduresDto);

        System.out.println("Сохранённый продукт" + proceduresService.updateProcedures(proceduresDto));
    }
    @DeleteMapping
    public void deleteDish(@RequestParam("id") Long id){
        proceduresService.deleteProcedures(id);
    }
}
