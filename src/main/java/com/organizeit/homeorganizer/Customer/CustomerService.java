package com.organizeit.homeorganizer.Customer;

import com.organizeit.homeorganizer.Customer.Dto.CustomerDto;
import com.organizeit.homeorganizer.Customer.Exception.CustomerNotFoundException;
import com.organizeit.homeorganizer.Customer.Dto.CustomerRequestData;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponse createCustomer(CustomerRequestData customerData) {
        CustomerDto customerDto = customerMapper.customerRequestDataToDto(customerData);
        customerDto.setId(UUID.randomUUID());

        Customer customer = customerMapper.customerDtoToEntity(customerDto);
        customerRepository.save(customer);

        return customerMapper.customerDtoToResponse(customerDto);

    }

    public CustomerResponse getCustomer(UUID id) {
        CustomerDto customerDto = customerMapper.customerEntityToDto(this.getCustomerEntity(id));
        return customerMapper.customerDtoToResponse(customerDto);
    }

    public Customer getCustomerEntity(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> {
            throw new CustomerNotFoundException();
        });
    }

    public void saveCustomerChanges(Customer customer) {
        customerRepository.save(customer);
    }
}
