package com.organizeit.homeorganizer.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Task.TaskHistory;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PACKAGE)
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private Set<Group> groups;

    @OneToMany
    @JoinColumn(name = "customer_task_history")
    private Set<TaskHistory> taskHistory = new HashSet<>();
}
