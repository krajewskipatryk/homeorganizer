package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Task.Dto.TaskTypeDto;
import com.organizeit.homeorganizer.Task.Dto.TaskTypeRequestData;
import com.organizeit.homeorganizer.Task.Dto.TaskTypeResponse;
import com.organizeit.homeorganizer.Task.Exception.TaskTypeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class TaskTypeService {
    private final TaskTypeMapper taskTypeMapper;
    private final TaskTypeRepository taskTypeRepository;


    public TaskTypeResponse createTaskType(TaskTypeRequestData taskTypeData) {
        TaskTypeDto taskTypeDto = taskTypeMapper.taskTypeRequestDataToDto(taskTypeData);
        taskTypeDto.setId(String.valueOf(UUID.randomUUID()));

        TaskType taskType = taskTypeMapper.taskTypeDtoToEntity(taskTypeDto);

        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    public TaskTypeResponse getTaskType(String id) {
        return taskTypeMapper.taskTypeEntityToTaskResponse(this.getTaskTypeEntity(id));
    }

    public TaskTypeResponse updateTaskType(TaskType taskType) {
        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    public TaskTypeResponse updateTaskType(String id, TaskTypeRequestData taskTypeData) {
        TaskTypeDto taskTypeDto = taskTypeMapper.taskTypeEntityToDto(this.getTaskTypeEntity(id));
        taskTypeDto = taskTypeMapper.taskTypeRequestDataToDto(taskTypeData);

        TaskType taskType = taskTypeMapper.taskTypeDtoToEntity(taskTypeDto);

        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    public TaskType getTaskTypeEntity(String id) {
        return taskTypeRepository.findById(id).orElseThrow(() -> {
            throw new TaskTypeNotFoundException();
        });
    }
}
