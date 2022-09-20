package com.organizeit.homeorganizer.Product.Api;

import com.organizeit.homeorganizer.Product.Api.Exception.ProductNotFoundException;
import com.organizeit.homeorganizer.Product.Api.Model.ProductDto;
import com.organizeit.homeorganizer.Product.Api.Model.ProductEntity;
import com.organizeit.homeorganizer.Product.Api.Model.ProductRequestData;
import com.organizeit.homeorganizer.Product.Api.Model.ProductResponse;
import com.organizeit.homeorganizer.Utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequestData productData) {
        ProductDto productDto = productMapper.productRequestToDto(productData);
        productDto.setId(IdGenerator.generateId());

        ProductEntity product = productMapper.productDtoToEntity(productDto);

        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse getProduct(String id) {
        return productMapper.productEntityToResponse(this.getProductEntity(id));
    }

    @Override
    public ProductResponse updateProduct(ProductEntity product) {
        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(String id, ProductRequestData productUpdatedData) {
        ProductEntity product = this.getProductEntity(id);
        product = productMapper.productRequestToEntity(productUpdatedData);
        product.setId(id);
        return productMapper.productEntityToResponse(productRepository.save(product));
    }

    @Override
    public ProductEntity getProductEntity(String id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFoundException();
        });
    }
}
