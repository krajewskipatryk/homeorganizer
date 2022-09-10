package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Api.GroupFacade;
import com.organizeit.homeorganizer.Group.Api.Model.GroupRequestData;
import com.organizeit.homeorganizer.Group.Api.Model.GroupResponse;
import com.organizeit.homeorganizer.Group.Api.Model.GroupUsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public GroupResponse getGroupInfo(@PathVariable String id) {
        return groupFacade.getGroupInfo(id);
    }

    @GetMapping(path = "/get/{id}/users")
    public GroupUsersResponse getGroupUsers(@PathVariable String id) {
        return groupFacade.getGroupUsers(id);
    }

    @PutMapping(path = "/update/{id}")
    public GroupResponse updateGroupInfo(@PathVariable String id, @RequestBody GroupRequestData groupData) {
        return groupFacade.updateGroupInfo(id, groupData);
    }

    @PutMapping(path = "/update/{groupId}/users/add/{userId}")
    public GroupUsersResponse addUserToGroup(@PathVariable String groupId, @PathVariable String userId) {
        return groupFacade.addUserToGroup(groupId, userId);
    }

    @PutMapping(path = "/update/{groupId}/users/remove/{userId}")
    public GroupUsersResponse removeUserFromGroup(@PathVariable String groupId, @PathVariable String userId) {
        return groupFacade.removeUserFromGroup(groupId, userId);
    }
}
