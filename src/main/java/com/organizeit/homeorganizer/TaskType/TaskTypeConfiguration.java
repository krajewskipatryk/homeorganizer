package com.organizeit.homeorganizer.TaskType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskTypeConfiguration {
    @Bean
    TaskTypeService taskTypeService(TaskTypeRepository taskTypeRepository) {
        return new TaskTypeService(taskTypeRepository);
    }
}
