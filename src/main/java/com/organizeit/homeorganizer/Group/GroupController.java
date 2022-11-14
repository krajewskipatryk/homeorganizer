package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import com.organizeit.homeorganizer.Task.HouseWork;
import com.organizeit.homeorganizer.Task.ShoppingList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("group")
@RequiredArgsConstructor
class GroupController {
    private final GroupFacade groupFacade;

    @PostMapping(path = "/create")
    public GroupResponse createGroup(@RequestBody GroupRequestData groupData) {
        return groupFacade.createGroup(groupData);
    }

    @GetMapping(path = "/get/{id}")
    public GroupResponse getGroupInfo(@PathVariable UUID id) {
        return groupFacade.getGroupInfo(id);
    }

    @GetMapping(path = "/get/{id}/customers")
    public GroupCustomersResponse getGroupUsers(@PathVariable UUID id) {
        return groupFacade.getGroupCustomers(id);
    }

    @PutMapping(path = "/update/{groupId}/customer/{customerId}/add")
    public GroupCustomersResponse addUserToGroup(@PathVariable UUID groupId, @PathVariable UUID customerId) {
        return groupFacade.addCustomerToGroup(groupId, customerId);
    }

    @PutMapping(path = "/update/{groupId}/customer/{customerId}/remove")
    public GroupCustomersResponse removeUserFromGroup(@PathVariable UUID groupId, @PathVariable UUID customerId) {
        return groupFacade.removeCustomerFromGroup(groupId, customerId);
    }

    @PostMapping(path = "/{groupId}/add/housework")
    public UUID addHouseWorkService(@PathVariable UUID groupId) {
        HouseWork houseWork = groupFacade.addHouseWorkService(groupId);
        return houseWork.getId();
    }

    @PostMapping(path = "/{groupId}/add/shoppinglist")
    public UUID addShoppingListService(@PathVariable UUID groupId) {
        ShoppingList shoppingList = groupFacade.addShoppingListService(groupId);
        return shoppingList.getId();
    }
}
