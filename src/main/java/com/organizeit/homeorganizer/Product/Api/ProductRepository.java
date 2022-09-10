package com.organizeit.homeorganizer.Product.Api;

import com.organizeit.homeorganizer.Product.Api.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ProductRepository extends JpaRepository<ProductEntity, String> {
    Optional<ProductEntity> findById(String id);
}
