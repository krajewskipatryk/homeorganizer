package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Task.Dto.ProductDto;
import com.organizeit.homeorganizer.Task.Dto.ProductRequestData;
import com.organizeit.homeorganizer.Task.Dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {
    Product productDtoToEntity(ProductDto productDto);
    ProductDto productEntityToDto(Product product);
    ProductDto productRequestToDto(ProductRequestData productData);
    ProductResponse productEntityToResponse(Product product);
    Product productRequestToEntity(ProductRequestData productData);
}
