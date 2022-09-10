package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;

interface GroupService {
    GroupResponse createGroup(GroupRequestData groupData);
    GroupResponse getGroup(String id);
    GroupResponse updateGroup(GroupEntity group);
    GroupResponse updateGroup(String id, GroupRequestData groupData);
    GroupUsersResponse getGroupUsers(String id);
    GroupEntity getGroupEntity(String id);
}
