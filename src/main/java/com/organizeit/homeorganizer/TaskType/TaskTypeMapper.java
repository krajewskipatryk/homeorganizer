package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.TaskType.Dto.TaskTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface TaskTypeMapper {
    TaskType taskTypeDtoToEntity(TaskTypeDto taskTypeDto);
    TaskTypeDto taskTypeEntityToDto(TaskType taskType);
}
