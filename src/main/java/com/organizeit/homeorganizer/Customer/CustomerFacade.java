package com.organizeit.homeorganizer.Customer;

import com.organizeit.homeorganizer.Customer.Dto.CustomerRequestData;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Task.TaskHistory;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CustomerFacade {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    CustomerResponse createCustomer(CustomerRequestData customerData) {
        return customerService.createCustomer(customerData);
    }

    public CustomerResponse getCustomer(UUID id) {
        return customerService.getCustomer(id);
    }

    public Customer getCustomerEntity(UUID id) {
        return customerService.getCustomerEntity(id);
    }

    public void addGroup(Group group, Customer customer) {
        customer.addGroup(group);

        customerService.saveCustomerChanges(customer);
    }

    public void removeGroup(Group group, Customer customer) {
        customer.removeGroup(group);

        customerService.saveCustomerChanges(customer);
    }

    public void addTaskHistory(Customer customer, TaskHistory taskHistory) {
        customer.getTaskHistory().add(taskHistory);
        customerService.saveCustomerChanges(customer);
    }

    public CustomerResponse mapCustomerToCustomerResponse(Customer customer) {
        return customerMapper.customerEntityToResponse(customer);
    }
}
