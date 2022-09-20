package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeRequestData;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeResponse;
import com.organizeit.homeorganizer.TaskType.Api.TaskTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("type")
@RequiredArgsConstructor
class TaskTypeController {
    private final TaskTypeService taskTypeService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaskTypeResponse createUser(@RequestBody TaskTypeRequestData taskTypeData) {
        return taskTypeService.createTaskType(taskTypeData);
    }

    @GetMapping(path = "/get/{id}")
    public TaskTypeResponse createUser(@PathVariable String id) {
        return taskTypeService.getTaskType(id);
    }

    @PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaskTypeResponse updateUser(@PathVariable String id, @RequestBody TaskTypeRequestData taskTypeUpdatedData) {
        return taskTypeService.updateTaskType(id, taskTypeUpdatedData);
    }
}
