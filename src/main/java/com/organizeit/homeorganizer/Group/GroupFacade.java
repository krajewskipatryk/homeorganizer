package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Customer.Dto.CustomerResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Task.HouseWork;
import com.organizeit.homeorganizer.Task.ShoppingList;
import com.organizeit.homeorganizer.Task.TaskFacade;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GroupFacade {
    private final GroupService groupService;
    private final CustomerFacade customerFacade;
    private final GroupMapper groupMapper;
    private final TaskFacade taskFacade;

    public GroupResponse createGroup(GroupRequestData groupData) {
        return groupService.createGroup(groupData);
    }

    public HouseWork addHouseWorkService(UUID groupId) {
        Group group = groupService.getGroupEntity(groupId);

        HouseWork houseWork = taskFacade.createHouseWork(group);

        group.setHouseWork(houseWork);

        groupService.saveGroupChanges(group);

        return houseWork;
    }

    public ShoppingList addShoppingListService(UUID groupId) {
        Group group = groupService.getGroupEntity(groupId);

        ShoppingList shoppingList = taskFacade.createShoppingList(group);

        group.setShoppingList(shoppingList);

        groupService.saveGroupChanges(group);

        return shoppingList;
    }

    public GroupResponse getGroupInfo(UUID id) {
        return groupService.getGroup(id);
    }

    public GroupCustomersResponse addCustomerToGroup(UUID groupId, UUID customerId) {
        Group group = groupService.getGroupEntity(groupId);
        Customer customer = customerFacade.getCustomerEntity(customerId);

        group.addCustomer(customer);

        groupService.saveGroupChanges(group);

        customerFacade.addGroup(group, customer);

        return this.getGroupCustomers(groupId);
    }

    public GroupCustomersResponse removeCustomerFromGroup(UUID groupId, UUID customerId) {
        Group group = groupService.getGroupEntity(groupId);
        Customer customer = customerFacade.getCustomerEntity(customerId);

        group.removeCustomer(customer);

        groupService.saveGroupChanges(group);

        customerFacade.removeGroup(group, customer);

        return this.getGroupCustomers(groupId);
    }

    public GroupCustomersResponse getGroupCustomers(UUID id) {
        Set<CustomerResponse> customersList = groupService.getGroupCustomers(id).stream()
                .map(customerFacade::mapCustomerToCustomerResponse)
                .collect(Collectors.toSet());

        GroupCustomersResponse groupMembers = new GroupCustomersResponse();

        groupMembers.setMembers(customersList);

        return groupMembers;
    }
}
