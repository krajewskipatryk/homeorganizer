package com.organizeit.homeorganizer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findById(String id);
}