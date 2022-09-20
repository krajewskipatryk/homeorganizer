package com.organizeit.homeorganizer.TaskType.Api;

import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeDto;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeEntity;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeRequestData;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeResponse;
import com.organizeit.homeorganizer.TaskType.Api.Exception.TaskTypeNotFoundException;
import com.organizeit.homeorganizer.Utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TaskTypeServiceImpl implements TaskTypeService {
    private final TaskTypeMapper taskTypeMapper;
    private final TaskTypeRepository taskTypeRepository;

    @Override
    public TaskTypeResponse createTaskType(TaskTypeRequestData taskTypeData) {
        TaskTypeDto taskTypeDto = taskTypeMapper.taskTypeRequestDataToDto(taskTypeData);
        taskTypeDto.setId(IdGenerator.generateId());

        TaskTypeEntity taskType = taskTypeMapper.taskTypeDtoToEntity(taskTypeDto);

        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    @Override
    public TaskTypeResponse getTaskType(String id) {
        return taskTypeMapper.taskTypeEntityToTaskResponse(this.getTaskTypeEntity(id));
    }

    @Override
    public TaskTypeResponse updateTaskType(TaskTypeEntity taskType) {
        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    @Override
    public TaskTypeResponse updateTaskType(String id, TaskTypeRequestData taskTypeData) {
        TaskTypeDto taskTypeDto = taskTypeMapper.taskTypeEntityToDto(this.getTaskTypeEntity(id));
        taskTypeDto = taskTypeMapper.taskTypeRequestDataToDto(taskTypeData);

        TaskTypeEntity taskType = taskTypeMapper.taskTypeDtoToEntity(taskTypeDto);

        return taskTypeMapper.taskTypeEntityToTaskResponse(taskTypeRepository.save(taskType));
    }

    @Override
    public TaskTypeEntity getTaskTypeEntity(String id) {
        return taskTypeRepository.findById(id).orElseThrow(() -> {
            throw new TaskTypeNotFoundException();
        });
    }
}
