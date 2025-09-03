package com.veterinary_clinic.veterinary_clinic.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;
    private final ProductRepository productRepository;

    public List<CategoryProductDto> findAll(){
        return categoryProductRepository.findAll().stream()
                .map(category -> new CategoryProductDto(category.getId(), category.getName()))
                .toList();
    }
    public CategoryProduct save(CategoryProduct category){
        return categoryProductRepository.save(category);
    }

    @Cacheable("menu")
    public List<CategoryWithProductDto>  getMenu(){
        // Получаем все категории
        List<CategoryProduct> categories = categoryProductRepository.findAll();

// Получаем все блюда одним запросом
        List<Product> products = productRepository.findAll();

// Группируем блюда по категории
        Map<CategoryProduct, List<Product>> productByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

// Собираем DTO
        List<CategoryWithProductDto> result = categories.stream()
                .map(cat -> new CategoryWithProductDto(
                        cat.getName(),
                        productByCategory.getOrDefault(cat, List.of())
                ))
                .toList();
        return result;
    }
}
