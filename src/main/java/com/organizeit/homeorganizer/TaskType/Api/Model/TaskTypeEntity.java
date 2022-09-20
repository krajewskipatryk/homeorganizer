package com.organizeit.homeorganizer.TaskType.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task_types")
public class TaskTypeEntity {
    @Id
    private String id;
    private String name;
}
