package com.organizeit.homeorganizer.Task.Exception;

import com.organizeit.homeorganizer.Exception.RecordNotFoundException;

public class ProductNotFoundException extends RecordNotFoundException {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
