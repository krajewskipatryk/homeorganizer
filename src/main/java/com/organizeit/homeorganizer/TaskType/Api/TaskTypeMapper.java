package com.organizeit.homeorganizer.TaskType.Api;

import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeDto;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeEntity;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeRequestData;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TaskTypeMapper {
    TaskTypeResponse taskTypeEntityToTaskResponse(TaskTypeEntity taskType);
    TaskTypeDto taskTypeRequestDataToDto(TaskTypeRequestData taskTypeData);
    TaskTypeEntity taskTypeRequestDataToEntity(TaskTypeRequestData taskTypeData);
    TaskTypeEntity taskTypeDtoToEntity(TaskTypeDto taskTypeDto);
    TaskTypeDto taskTypeEntityToDto(TaskTypeEntity taskType);
}
