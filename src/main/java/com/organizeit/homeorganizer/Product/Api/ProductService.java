package com.organizeit.homeorganizer.Product.Api;

import com.organizeit.homeorganizer.Product.Api.Model.ProductEntity;
import com.organizeit.homeorganizer.Product.Api.Model.ProductRequestData;
import com.organizeit.homeorganizer.Product.Api.Model.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequestData productData);
    ProductResponse getProduct(String id);
    ProductResponse updateProduct(ProductEntity product);
    ProductResponse updateProduct(String id, ProductRequestData productUpdatedData);
    ProductEntity getProductEntity(String id);
}
