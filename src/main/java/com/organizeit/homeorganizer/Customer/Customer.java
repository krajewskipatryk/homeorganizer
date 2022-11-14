package com.organizeit.homeorganizer.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Task.TaskHistory;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Getter
    private UUID id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private Set<Group> groups;

    @JsonIgnore
    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    @OneToMany
    @JoinColumn(name = "customer_task_history")
    private Set<TaskHistory> taskHistory = new HashSet<>();

    void addGroup(Group group) {
        if (!groups.contains(group)) {
            groups.add(group);
        }
    }

    void removeGroup(Group group) {
        if (groups.contains(group)) {
            groups.remove(group);
        }
    }
}
