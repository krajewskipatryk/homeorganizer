package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.TaskType.Dto.TaskTypeDto;
import com.organizeit.homeorganizer.TaskType.Exception.TaskTypeNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TaskTypeService {
    private final TaskTypeMapper taskTypeMapper;
    private final TaskTypeRepository taskTypeRepository;


    public TaskType createTaskType(String name) {
        TaskTypeDto taskTypeDto = new TaskTypeDto(UUID.randomUUID(), name);

        TaskType taskType = taskTypeMapper.taskTypeDtoToEntity(taskTypeDto);
        return taskTypeRepository.save(taskType);
    }

    public TaskType getTaskTypeEntity(UUID id) {
        return taskTypeRepository.findById(id).orElseThrow(() -> {
            throw new TaskTypeNotFoundException();
        });
    }
}
