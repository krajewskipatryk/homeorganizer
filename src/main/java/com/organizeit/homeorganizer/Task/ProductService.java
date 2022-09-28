package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Task.Exception.ProductNotFoundException;
import com.organizeit.homeorganizer.Task.Dto.ProductDto;
import com.organizeit.homeorganizer.Task.Dto.ProductRequestData;
import com.organizeit.homeorganizer.Task.Dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequestData productData) {
        ProductDto productDto = productMapper.productRequestToDto(productData);
        productDto.setId(String.valueOf(UUID.randomUUID()));

        Product product = productMapper.productDtoToEntity(productDto);

        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    public ProductResponse getProduct(String id) {
        return productMapper.productEntityToResponse(this.getProductEntity(id));
    }

    public ProductResponse updateProduct(Product product) {
        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    public ProductResponse updateProduct(String id, ProductRequestData productUpdatedData) {
        Product product = this.getProductEntity(id);
        product = productMapper.productRequestToEntity(productUpdatedData);
        product.setId(id);
        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    public Product getProductEntity(String id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFoundException();
        });
    }
}
