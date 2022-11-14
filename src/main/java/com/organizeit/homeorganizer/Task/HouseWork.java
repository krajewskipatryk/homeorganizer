package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "house_work")
public class HouseWork {
    @Id
    @Getter
    private UUID id;

    @Getter
    @OneToOne
    private Group group;

    @Getter
    @OneToMany
    private Set<TaskHistory> taskHistory;

    @Getter
    @OneToMany
    private Set<TaskType> taskList;

}
