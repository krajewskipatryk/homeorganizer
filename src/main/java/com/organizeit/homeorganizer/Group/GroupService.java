package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Group.Exception.GroupNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GroupResponse createGroup(GroupRequestData groupData) {
        Group group = Group.builder()
                .id(UUID.randomUUID())
                .name(groupData.getName())
                .build();

        groupRepository.save(group);

        return groupMapper.groupEntityToResponse(group);
    }

    public GroupResponse getGroup(UUID id) {
        GroupDto groupDto = groupMapper.groupEntityToDto(this.getGroupEntity(id));
        return groupMapper.groupDtoToResponse(groupDto);
    }

    public Set<Customer> getGroupCustomers(UUID id) {
        return this.getGroupEntity(id).getMembers();
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
