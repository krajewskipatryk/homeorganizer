package com.organizeit.homeorganizer.Group.Exception;

import com.organizeit.homeorganizer.Exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GroupControllerAdvice {
    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<ApiError> groupNotFoundAdvice() {
        return new ResponseEntity<ApiError>(new ApiError("Group not found!", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
