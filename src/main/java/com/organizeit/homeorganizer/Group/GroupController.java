package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
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

    @PutMapping(path = "/update/{groupId}/customers/add/{customerId}")
    public GroupCustomersResponse addUserToGroup(@PathVariable UUID groupId, @PathVariable UUID customerId) {
        return groupFacade.addCustomerToGroup(groupId, customerId);
    }

    @PutMapping(path = "/update/{groupId}/customers/remove/{customerId}")
    public GroupCustomersResponse removeUserFromGroup(@PathVariable UUID groupId, @PathVariable UUID customerId) {
        return groupFacade.removeCustomerFromGroup(groupId, customerId);
    }
}
