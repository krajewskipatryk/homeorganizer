package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Task.Dto.TaskTypeDto;
import com.organizeit.homeorganizer.Task.Dto.TaskTypeRequestData;
import com.organizeit.homeorganizer.Task.Dto.TaskTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TaskTypeMapper {
    TaskTypeResponse taskTypeEntityToTaskResponse(TaskType taskType);
    TaskTypeDto taskTypeRequestDataToDto(TaskTypeRequestData taskTypeData);
    TaskType taskTypeRequestDataToEntity(TaskTypeRequestData taskTypeData);
    TaskType taskTypeDtoToEntity(TaskTypeDto taskTypeDto);
    TaskTypeDto taskTypeEntityToDto(TaskType taskType);
}
