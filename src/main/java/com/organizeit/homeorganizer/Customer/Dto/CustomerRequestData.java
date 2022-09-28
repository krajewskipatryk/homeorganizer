package com.organizeit.homeorganizer.Customer.Dto;

import lombok.Data;

@Data
public class CustomerRequestData {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
