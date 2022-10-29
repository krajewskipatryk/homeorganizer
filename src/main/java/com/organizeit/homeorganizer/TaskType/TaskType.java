package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.Task.TaskHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task_types")
public class TaskType {
    @Id
    @Getter
    private UUID id;

    @Getter
    private String name;
}
