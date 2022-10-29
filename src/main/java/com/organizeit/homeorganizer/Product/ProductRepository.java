package com.organizeit.homeorganizer.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findById(UUID id);
}
