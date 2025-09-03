package com.veterinary_clinic.veterinary_clinic.product;

import com.veterinary_clinic.veterinary_clinic.product.*;
import com.veterinary_clinic.veterinary_clinic.util.AddImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository dishRepository;
    private final CategoryProductRepository categoryRepository;
    private final AddImageService addImageService;

    public List<ProductDto> findAll(){
        return dishRepository.findAll().stream().map(product -> ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category_id(product.getCategory().getId())
                .category_name(product.getCategory().getName())
                .description(product.getDescription())
                .image_path(product.getImage_path())
                .price(product.getPrice())
                .on_main(product.isOn_main()).build()
        ).toList();
    }
    public Product save(ProductDto productDto) throws IOException {
        CategoryProduct category = categoryRepository.findByName(productDto.category_name()).orElse(new CategoryProduct());
        Product newProduct = Product.builder()
                .name(productDto.name())
                .price(productDto.price())
                .description(productDto.description())
                .category(category)
                .image_path(addImageService.addImageCloudinary(productDto.image()))
                .on_main(productDto.on_main())
                .build();
        return dishRepository.save(newProduct);
    }
    public ProductDto findById(Long id){
        Product product = dishRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category_id(product.getCategory().getId())
                .category_name(product.getCategory().getName())
                .description(product.getDescription())
                .image_path(product.getImage_path())
                .on_main(product.isOn_main())
                .price(product.getPrice()).build();

    }

    public Product updateProduct(ProductDto productDto) throws IOException {
        Product product = dishRepository.findById(productDto.id()).orElse(new Product());
        CategoryProduct category = categoryRepository.findByName(productDto.category_name()).orElseThrow(() -> new RuntimeException());
        Product newProduct = Product.builder()
                .name(productDto.name())
                .price(productDto.price())
                .id(productDto.id())
                .description(productDto.description())
                .category(category)
                .on_main(productDto.on_main())
                .image_path(productDto.image() == null ? product.getImage_path() : addImageService.addImageCloudinary(productDto.image()))
                .build();
        return dishRepository.save(newProduct);
    }

    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }
}
