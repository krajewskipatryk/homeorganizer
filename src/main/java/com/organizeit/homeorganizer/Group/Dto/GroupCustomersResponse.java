package com.organizeit.homeorganizer.Group.Dto;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import lombok.Data;

import java.util.Set;

@Data
public class GroupCustomersResponse {
    private Set<CustomerResponse> members;
}
