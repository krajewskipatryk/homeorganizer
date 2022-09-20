package com.organizeit.homeorganizer.TaskType.Api;

import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeEntity;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeRequestData;
import com.organizeit.homeorganizer.TaskType.Api.Model.TaskTypeResponse;

public interface TaskTypeService {
    TaskTypeResponse createTaskType(TaskTypeRequestData taskTypeData);
    TaskTypeResponse getTaskType(String id);
    TaskTypeResponse updateTaskType(TaskTypeEntity taskType);
    TaskTypeResponse updateTaskType(String id, TaskTypeRequestData taskTypeData);
    TaskTypeEntity getTaskTypeEntity(String id);
}
