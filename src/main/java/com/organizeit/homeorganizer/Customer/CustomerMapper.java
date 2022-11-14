package com.organizeit.homeorganizer.Customer;

import com.organizeit.homeorganizer.Customer.Dto.CustomerDto;
import com.organizeit.homeorganizer.Customer.Dto.CustomerRequestData;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface CustomerMapper {
    Customer customerDtoToEntity(CustomerDto customerDto);
    CustomerDto customerEntityToDto(Customer customer);
    CustomerResponse customerEntityToResponse(Customer customer);
}
