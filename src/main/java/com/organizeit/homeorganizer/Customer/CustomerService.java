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
//        CustomerDto customerDto = customerMapper.customerRequestDataToDto(customerData);
//        customerDto.setId(UUID.randomUUID());

        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setEmail(customerData.getEmail());
        customer.setFirstName(customerData.getFirstName());
        customer.setPassword(customerData.getPassword());
        customer.setLastName(customerData.getLastName());
        customerRepository.save(customer);

        CustomerDto responseDto = customerMapper.customerEntityToDto(customer);

        return customerMapper.customerDtoToResponse(responseDto);

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
