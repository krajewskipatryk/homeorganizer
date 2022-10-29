package com.organizeit.homeorganizer.Product;

import com.organizeit.homeorganizer.Product.Exception.ProductNotFoundException;
import com.organizeit.homeorganizer.Product.Dto.ProductDto;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product createProduct(String name) {
        ProductDto productDto = new ProductDto(UUID.randomUUID(), name);

        Product product = productMapper.productDtoToEntity(productDto);

        return productRepository.save(product);
    }

    public Product getProductEntity(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFoundException();
        });
    }
}
