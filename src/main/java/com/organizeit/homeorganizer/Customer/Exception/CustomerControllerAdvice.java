package com.organizeit.homeorganizer.Customer.Exception;

import com.organizeit.homeorganizer.Exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomerControllerAdvice {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiError> customerNotFoundAdvice() {
        return new ResponseEntity<ApiError>(new ApiError("User not found!", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
