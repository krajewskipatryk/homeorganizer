package com.organizeit.homeorganizer.TaskType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskTypeConfiguration {
    @Bean
    TaskTypeService taskTypeService(TaskTypeRepository taskTypeRepository, TaskTypeMapper taskTypeMapper) {
        return new TaskTypeService(taskTypeMapper, taskTypeRepository);
    }
}
