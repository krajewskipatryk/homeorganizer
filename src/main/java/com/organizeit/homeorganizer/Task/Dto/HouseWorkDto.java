package com.organizeit.homeorganizer.Task.Dto;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Product.Product;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseWorkDto {
    private UUID id;
    private LocalDate taskCompletionDate;
    private Customer customer;
    private Product product;
    private TaskType taskType;
}
