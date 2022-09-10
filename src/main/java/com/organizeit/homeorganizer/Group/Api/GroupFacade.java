package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;

public interface GroupFacade {
    GroupResponse createGroup(GroupRequestData groupData);
    GroupResponse getGroupInfo(String id);
    GroupResponse updateGroupInfo(String id, GroupRequestData groupData);
    GroupUsersResponse addUserToGroup(String groupId, String userId);
    GroupUsersResponse removeUserFromGroup(String groupId, String userId);
    GroupUsersResponse getGroupUsers(String id);
}
