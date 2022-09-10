package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface GroupMapper {
    GroupEntity groupRequestToEntity(GroupRequestData groupData);
    GroupResponse groupEntityToResponse(GroupEntity group);
    GroupUsersResponse groupEntityToUsersResponse(GroupEntity group);
}
