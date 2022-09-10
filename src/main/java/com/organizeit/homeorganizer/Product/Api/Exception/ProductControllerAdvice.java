package com.organizeit.homeorganizer.Product.Api.Exception;

import com.organizeit.homeorganizer.Utils.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> productNotFoundAdvice() {
        return new ResponseEntity<ApiError>(new ApiError("Product not found!", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
