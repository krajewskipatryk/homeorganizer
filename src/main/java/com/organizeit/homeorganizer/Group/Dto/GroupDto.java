package com.organizeit.homeorganizer.Group.Dto;

import com.organizeit.homeorganizer.Customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private UUID id;
    private String name;
    private Set<Customer> members;

    public void addCustomer(Customer customer) {
        this.members.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.members.remove(customer);
    }
}
