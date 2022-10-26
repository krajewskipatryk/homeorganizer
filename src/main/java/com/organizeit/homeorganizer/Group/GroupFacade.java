package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GroupFacade {
    private final GroupService groupService;
    private final CustomerFacade customerFacade;
    private final GroupMapper groupMapper;

    public GroupResponse createGroup(GroupRequestData groupData) {
        return groupService.createGroup(groupData);
    }

    public GroupResponse getGroupInfo(UUID id) {
        return groupService.getGroup(id);
    }

    public GroupCustomersResponse addCustomerToGroup(UUID groupId, UUID customerId) {
        GroupDto groupDto = groupMapper.groupEntityToDto(groupService.getGroupEntity(groupId));
        Customer customer = customerFacade.getCustomerEntity(customerId);

        groupDto.addCustomer(customer);

        Group group = groupMapper.groupDtoToEntity(groupDto);

        groupService.saveGroupChanges(group);

        customerFacade.addGroup(group, customer);

        return groupMapper.groupDtoToUsersResponse(groupDto);
    }

    public GroupCustomersResponse removeCustomerFromGroup(UUID groupId, UUID customerId) {
        GroupDto groupDto = groupMapper.groupEntityToDto(groupService.getGroupEntity(groupId));
        Customer customer = customerFacade.getCustomerEntity(customerId);

        groupDto.removeCustomer(customer);

        Group group = groupMapper.groupDtoToEntity(groupDto);

        groupService.saveGroupChanges(group);

        customerFacade.removeGroup(group, customer);

        return groupMapper.groupDtoToUsersResponse(groupDto);
    }

    public GroupCustomersResponse getGroupCustomers(UUID id) {
        return groupService.getGroupCustomers(id);
    }
}
