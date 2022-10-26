package com.organizeit.homeorganizer.Group.Dto;

import com.organizeit.homeorganizer.Customer.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class GroupCustomersResponse {
    private Set<Customer> members;
}
