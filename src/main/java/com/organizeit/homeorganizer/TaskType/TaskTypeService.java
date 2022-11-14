package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.TaskType.Exception.TaskTypeNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TaskTypeService {
    private final TaskTypeRepository taskTypeRepository;

    public TaskType createTaskType(String name) {
        TaskType taskType = TaskType.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();
        
        return taskTypeRepository.save(taskType);
    }

    public TaskType getTaskTypeEntity(UUID id) {
        return taskTypeRepository.findById(id).orElseThrow(() -> {
            throw new TaskTypeNotFoundException();
        });
    }
}
