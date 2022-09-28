package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Group.Exception.GroupNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupResponse createGroup(GroupRequestData groupData) {
        GroupDto groupDto = groupMapper.groupRequestToDto(groupData);
        groupDto.setId(UUID.randomUUID());

        Group group = groupMapper.groupDtoToEntity(groupDto);
        groupRepository.save(group);

        return groupMapper.groupDtoToResponse(groupDto);
    }

    public GroupResponse getGroup(UUID id) {
        GroupDto groupDto = groupMapper.groupEntityToDto(this.getGroupEntity(id));
        return groupMapper.groupDtoToResponse(groupDto);
    }

    public GroupCustomersResponse getGroupCustomers(UUID id) {
        GroupDto groupDto = groupMapper.groupEntityToDto(this.getGroupEntity(id));
        return groupMapper.groupDtoToUsersResponse(groupDto);
    }

    public Group getGroupEntity(UUID id) {
        return groupRepository.findById(id).orElseThrow(() -> {
            throw new GroupNotFoundException();
        });
    }

    public void saveGroupChanges(Group group) {
        groupRepository.save(group);
    }
}
