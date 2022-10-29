package com.organizeit.homeorganizer.Product;

import com.organizeit.homeorganizer.Product.Dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {
    Product productDtoToEntity(ProductDto productDto);
    ProductDto productEntityToDto(Product product);
}
