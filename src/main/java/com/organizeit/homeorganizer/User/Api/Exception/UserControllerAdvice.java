package com.organizeit.homeorganizer.User.Api.Exception;

import com.organizeit.homeorganizer.Utils.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> userNotFoundAdvice() {
        return new ResponseEntity<ApiError>(new ApiError("User not found!", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
