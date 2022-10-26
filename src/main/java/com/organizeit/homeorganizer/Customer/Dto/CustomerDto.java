package com.organizeit.homeorganizer.Customer.Dto;

import com.organizeit.homeorganizer.Group.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class CustomerDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Group> groups;

    public void addGroup(Group group) {
        this.groups.add(group);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }
}
