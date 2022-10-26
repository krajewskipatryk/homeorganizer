package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Task.Dto.TaskTypeRequestData;
import com.organizeit.homeorganizer.Task.Dto.TaskTypeResponse;
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
