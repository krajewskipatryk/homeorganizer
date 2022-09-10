package com.organizeit.homeorganizer.User.Api;

import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import com.organizeit.homeorganizer.User.Api.Model.UserRequestData;
import com.organizeit.homeorganizer.User.Api.Model.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequestData userData);
    UserResponse getUser(String id);
    UserResponse updateUser(UserEntity user);
    UserResponse updateUser(String id, UserRequestData userData);
    UserEntity getUserEntity(String id);
}
