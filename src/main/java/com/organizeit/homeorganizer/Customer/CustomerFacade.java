package com.organizeit.homeorganizer.Customer;

import com.organizeit.homeorganizer.Customer.Dto.CustomerDto;
import com.organizeit.homeorganizer.Customer.Dto.CustomerRequestData;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import com.organizeit.homeorganizer.Group.Group;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    CustomerResponse createCustomer(CustomerRequestData customerData) {
        return customerService.createCustomer(customerData);
    }

    CustomerResponse getCustomer(UUID id) {
        return customerService.getCustomer(id);
    }

    public Customer getCustomerEntity(UUID id) {
        return customerService.getCustomerEntity(id);
    }

    public void addGroup(Group group, Customer customer) {
        CustomerDto customerDto = customerMapper.customerEntityToDto(customer);

        customerDto.addGroup(group);

        customerService.saveCustomerChanges(customerMapper.customerDtoToEntity(customerDto));
    }

    public void removeGroup(Group group, Customer customer) {
        CustomerDto customerDto = customerMapper.customerEntityToDto(customer);

        customerDto.removeGroup(group);

        customerService.saveCustomerChanges(customerMapper.customerDtoToEntity(customerDto));
    }
}
