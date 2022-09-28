package com.organizeit.homeorganizer.Customer;

import com.organizeit.homeorganizer.Customer.Dto.CustomerRequestData;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
class CustomerController {
    private final CustomerFacade customerFacade;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse createCustomer(@RequestBody CustomerRequestData userData) {
        return customerFacade.createCustomer(userData);
    }

    @GetMapping(path = "/get/{id}")
    public CustomerResponse getCustomer(@PathVariable UUID id) {
        return customerFacade.getCustomer(id);
    }
}
