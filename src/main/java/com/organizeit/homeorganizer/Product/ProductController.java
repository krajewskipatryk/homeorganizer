package com.organizeit.homeorganizer.Product;

import com.organizeit.homeorganizer.Product.Api.Model.ProductRequestData;
import com.organizeit.homeorganizer.Product.Api.Model.ProductResponse;
import com.organizeit.homeorganizer.Product.Api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
class ProductController {
    private final ProductService productService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse createProduct(@RequestBody ProductRequestData productData) {
        return productService.createProduct(productData);
    }

    @GetMapping(path = "/get/{id}")
    public ProductResponse getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@PathVariable String id, @RequestBody ProductRequestData productData) {
        return productService.updateProduct(id, productData);
    }
}