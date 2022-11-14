package com.organizeit.homeorganizer.TaskType;

import com.organizeit.homeorganizer.Task.TaskHistory;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task_types")
public class TaskType {
    @Id
    @Getter
    private UUID id;

    @Getter
    private String name;
}
