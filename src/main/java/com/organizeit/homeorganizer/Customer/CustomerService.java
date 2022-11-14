package com.organizeit.homeorganizer.Customer;

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
        Customer customer = Customer.builder()
                .id(UUID.randomUUID())
                .firstName(customerData.getFirstName())
                .lastName(customerData.getLastName())
                .email(customerData.getEmail())
                .password(customerData.getPassword())
                .build();

        customerRepository.save(customer);

        return customerMapper.customerEntityToResponse(customer);

    }

    public CustomerResponse getCustomer(UUID id) {
        Customer customer = this.getCustomerEntity(id);
        return customerMapper.customerEntityToResponse(customer);
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
