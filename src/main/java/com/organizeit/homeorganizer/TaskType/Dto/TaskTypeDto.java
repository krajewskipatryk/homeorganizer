package com.organizeit.homeorganizer.TaskType.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeDto {
    private UUID id;
    private String name;
}
