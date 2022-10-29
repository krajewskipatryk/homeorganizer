package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

import static java.util.Objects.*;

@MappedSuperclass
@AllArgsConstructor
abstract class Task {

    @Id
    @Getter
    private UUID id;

    @Getter
    @OneToOne
    private Group group;

    @Getter
    @Setter
    @OneToMany
    private Set<TaskHistory> taskHistory;

    @PrePersist
    public void idCheck() {
        if (isNull(id)) {
            id = UUID.randomUUID();
        }
    }
}