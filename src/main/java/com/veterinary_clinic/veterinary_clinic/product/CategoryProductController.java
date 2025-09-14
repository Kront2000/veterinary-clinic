package com.veterinary_clinic.veterinary_clinic.product;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/categoryProduct")
public class CategoryProductController {

    private final CategoryProductService service;


    @GetMapping
    public List<CategoryProductDto> findAll(){
        return service.findAll();
    }
    @PostMapping("/save_category")
    public CategoryProduct save(@RequestBody CategoryProduct category){
        return service.save(category);
    }
}
