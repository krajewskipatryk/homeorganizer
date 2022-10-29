package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "house_work")
public class HouseWork extends Task {
    public HouseWork(UUID id, Group group, Set<TaskHistory> taskHistory) {
        super(id, group, taskHistory);
    }

    @Getter
    @OneToMany
    private Set<TaskType> taskList = new HashSet<>();

}
