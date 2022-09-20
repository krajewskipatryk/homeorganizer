package com.organizeit.homeorganizer.Product.Api;

import com.organizeit.homeorganizer.Product.Api.Model.ProductDto;
import com.organizeit.homeorganizer.Product.Api.Model.ProductEntity;
import com.organizeit.homeorganizer.Product.Api.Model.ProductRequestData;
import com.organizeit.homeorganizer.Product.Api.Model.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface ProductMapper {
    ProductEntity productDtoToEntity(ProductDto productDto);
    ProductDto productEntityToDto(ProductEntity product);
    ProductDto productRequestToDto(ProductRequestData productData);
    ProductResponse productEntityToResponse(ProductEntity product);
    @Mapping(target = "id", ignore = true)
    ProductEntity productRequestToEntity(ProductRequestData productData);
}
