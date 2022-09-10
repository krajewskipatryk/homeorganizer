package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;
import com.organizeit.homeorganizer.User.Api.Model.UserEntity;
import com.organizeit.homeorganizer.User.Api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GroupFacadeImpl implements GroupFacade {
    private final GroupService groupService;
    private final UserService userService;
    private final GroupMapper groupMapper;

    @Override
    public GroupResponse createGroup(GroupRequestData groupData) {
        return groupService.createGroup(groupData);
    }

    @Override
    public GroupResponse getGroupInfo(String id) {
        return groupService.getGroup(id);
    }

    @Override
    public GroupResponse updateGroupInfo(String id, GroupRequestData groupData) {
        return groupService.updateGroup(id, groupData);
    }

    @Override
    public GroupUsersResponse addUserToGroup(String groupId, String userId) {
        GroupEntity group = groupService.getGroupEntity(groupId);
        UserEntity user = userService.getUserEntity(userId);

        group.addUser(user);
        user.addGroup(group);

        groupService.updateGroup(group);
        userService.updateUser(user);

        return groupMapper.groupEntityToUsersResponse(group);
    }

    @Override
    public GroupUsersResponse removeUserFromGroup(String groupId, String userId) {
        GroupEntity group = groupService.getGroupEntity(groupId);
        UserEntity user = userService.getUserEntity(userId);

        group.removeUser(user);
        user.removeGroup(group);

        groupService.updateGroup(group);
        userService.updateUser(user);

        return groupMapper.groupEntityToUsersResponse(group);
    }

    @Override
    public GroupUsersResponse getGroupUsers(String id) {
        return groupService.getGroupUsers(id);
    }
}
