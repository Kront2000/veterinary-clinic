package com.veterinary_clinic.veterinary_clinic.product;

import java.util.List;

public record CategoryWithProductDto(String name, List<Product> products) {
}
