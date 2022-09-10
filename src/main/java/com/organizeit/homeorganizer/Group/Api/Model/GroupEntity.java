package com.organizeit.homeorganizer.Group.Api.Model;

import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "groups")
public class GroupEntity {
    @Id
    private String id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "group_has_users",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> users = new HashSet<>();

    public void addUser(UserEntity user) {
        this.users.add(user);
    }

    public void removeUser(UserEntity user) {
        this.users.remove(user);
    }
}
