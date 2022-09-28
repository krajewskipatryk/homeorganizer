package com.organizeit.homeorganizer.Task.Exception;

import com.organizeit.homeorganizer.Exception.ApiError;
import com.organizeit.homeorganizer.Task.Exception.TaskTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskTypeControllerAdvice {
    @ExceptionHandler(TaskTypeNotFoundException.class)
    public ResponseEntity<ApiError> taskTypeNotFoundAdvice() {
        return new ResponseEntity<ApiError>(new ApiError("Task type not found!", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
