package com.organizeit.homeorganizer.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findById(String id);
}
