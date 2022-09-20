package com.organizeit.homeorganizer.User.Api.Model;

import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(mappedBy = "users")
    private Set<GroupEntity> groups = new HashSet<>();

    public void addGroup(GroupEntity group) {
        this.groups.add(group);
    }

    public void removeGroup(GroupEntity group) {
        this.groups.remove(group);
    }
}
