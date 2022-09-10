package com.organizeit.homeorganizer.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private HttpStatus httpStatus;
}
