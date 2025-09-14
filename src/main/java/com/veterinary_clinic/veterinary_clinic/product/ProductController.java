package com.veterinary_clinic.veterinary_clinic.product;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/apteka")
public class ProductController {
    private final ProductService productService;

    private Validator validator;

    private final CategoryProductService categoryService;

    @GetMapping
    public List<CategoryWithProductDto> getProductWithCategory(){
        return categoryService.getMenu();
    }

    @GetMapping("/getAll")
    public List<ProductDto> getAllProduct(){
        return productService.findAll();
    }

    @PostMapping("/add_product")
    @CacheEvict(value = "menu", allEntries = true)
    public void save(@RequestParam("name") String name,
                     @RequestParam("description") String description,
                     @RequestParam("category") String category,
                     @RequestParam("on_main") boolean on_main,
                     @RequestParam("price") Long price, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        ProductDto dishDto = ProductDto.builder()
                .name(name)
                .image(image)
                .price(price)
                .description(description)
                .category_name(category)
                .on_main(on_main)
                .build();
        System.out.println("Диш дто: " + dishDto);

        System.out.println("Сохранённый продукт" + productService.save(dishDto));
    }

    @GetMapping("/getById")
    public ProductDto getById(@RequestParam("id") String id){
        System.out.println("id - " + id);
        return productService.findById(Long.valueOf(id));
    }

    @PostMapping("/updateProduct")
    @CacheEvict(value = "menu", allEntries = true)
    public void updateDish(@RequestParam("id") Long id, @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("category") String category,
                           @RequestParam("on_main") boolean on_main,
                           @RequestParam("price") Long price, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        ProductDto productDto = ProductDto.builder()
                .id(id)
                .name(name)
                .image(image)
                .price(price)
                .description(description)
                .category_name(category)
                .on_main(on_main)
                .build();

        System.out.println("Диш дто: " + productDto);

        System.out.println("Сохранённый продукт" + productService.updateProduct(productDto));
    }
    @DeleteMapping

    public void deleteDish(@RequestParam("id") Long id){
        productService.deleteDish(id);
    }
}