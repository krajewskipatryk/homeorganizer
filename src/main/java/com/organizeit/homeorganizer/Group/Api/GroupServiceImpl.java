package com.organizeit.homeorganizer.Group.Api;

import com.organizeit.homeorganizer.Group.Api.Exception.GroupNotFoundException;
import com.organizeit.homeorganizer.Group.Api.Model.GroupEntity;
import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;
import com.organizeit.homeorganizer.Utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public GroupResponse createGroup(GroupRequestData groupData) {
        GroupEntity group = groupMapper.groupRequestToEntity(groupData);

        group.setId(IdGenerator.generateId());

        return groupMapper.groupEntityToResponse(groupRepository.save(group));
    }

    @Override
    public GroupResponse getGroup(String id) {
        return groupMapper.groupEntityToResponse(this.getGroupEntity(id));
    }

    @Override
    public GroupResponse updateGroup(GroupEntity group) {
        return groupMapper.groupEntityToResponse(groupRepository.save(group));
    }

    @Override
    public GroupResponse updateGroup(String id, GroupRequestData groupData) {
        GroupEntity group = this.getGroupEntity(id);
        group = groupMapper.groupRequestToEntity(groupData);
        return groupMapper.groupEntityToResponse(groupRepository.save(group));
    }

    @Override
    public GroupUsersResponse getGroupUsers(String id) {
        return groupMapper.groupEntityToUsersResponse(this.getGroupEntity(id));
    }

    @Override
    public GroupEntity getGroupEntity(String id) {
        return groupRepository.findById(id).orElseThrow(() -> {
            throw new GroupNotFoundException();
        });
    }
}
