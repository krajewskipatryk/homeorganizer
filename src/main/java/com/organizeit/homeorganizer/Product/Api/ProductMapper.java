package com.organizeit.homeorganizer.Product.Api;

import com.organizeit.homeorganizer.Product.Api.Model.ProductEntity;
import com.organizeit.homeorganizer.Product.Api.Model.ProductRequestData;
import com.organizeit.homeorganizer.Product.Api.Model.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {
    ProductEntity productRequestToEntity(ProductRequestData productData);
    ProductResponse productEntityToResponse(ProductEntity product);
}
