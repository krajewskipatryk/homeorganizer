package com.organizeit.homeorganizer.Product;

import com.organizeit.homeorganizer.Product.Exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(String name) {
        Product product = Product.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();

        return productRepository.save(product);
    }

    public Product getProductEntity(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFoundException();
        });
    }
}
