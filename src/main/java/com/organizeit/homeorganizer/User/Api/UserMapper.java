package com.organizeit.homeorganizer.User.Api;

import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import com.organizeit.homeorganizer.User.Api.Model.UserRequestData;
import com.organizeit.homeorganizer.User.Api.Model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface UserMapper {
    UserEntity userDataToEntity(UserRequestData userData);
    UserResponse userEntityToResponse(UserEntity user);
}
