package com.organizeit.homeorganizer.Group.Api.Model;

import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import lombok.Data;

import java.util.Set;

@Data
public class GroupUsersResponse {
    private Set<UserEntity> users;
}
