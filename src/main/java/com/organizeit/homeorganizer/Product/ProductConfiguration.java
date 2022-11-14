package com.organizeit.homeorganizer.Product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfiguration {
    @Bean
    ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
