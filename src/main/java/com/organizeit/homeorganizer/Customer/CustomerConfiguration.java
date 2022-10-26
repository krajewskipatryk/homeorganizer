package com.organizeit.homeorganizer.Customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CustomerConfiguration {
    @Bean
    CustomerService customerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        return new CustomerService(customerRepository, customerMapper);
    }

    @Bean
    CustomerFacade customerFacade(CustomerService customerService, CustomerMapper customerMapper) {
        return new CustomerFacade(customerService, customerMapper);
    }
}
