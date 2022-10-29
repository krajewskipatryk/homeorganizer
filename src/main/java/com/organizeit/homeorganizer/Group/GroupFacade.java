package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Task.HouseWork;
import com.organizeit.homeorganizer.Task.ShoppingList;
import com.organizeit.homeorganizer.Task.TaskFacade;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GroupFacade {
    private final GroupService groupService;
    private final CustomerFacade customerFacade;
    private final GroupMapper groupMapper;
    private final TaskFacade taskFacade;

    public GroupResponse createGroup(GroupRequestData groupData) {
        return groupService.createGroup(groupData);
    }

    public void addHouseWorkService(UUID groupId) {
        Group group = groupService.getGroupEntity(groupId);

        HouseWork houseWork = taskFacade.createHouseWork(group);

        group.setHouseWork(houseWork);

        groupService.saveGroupChanges(group);
    }

    public void addShoppingListService(UUID groupId) {
        Group group = groupService.getGroupEntity(groupId);

        ShoppingList shoppingList = taskFacade.createShoppingList(group);

        group.setShoppingList(shoppingList);

        groupService.saveGroupChanges(group);
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
