package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface GroupMapper {
    GroupDto groupRequestToDto(GroupRequestData groupData);
    GroupResponse groupDtoToResponse(GroupDto groupDto);
    GroupCustomersResponse groupDtoToUsersResponse(GroupDto groupDto);
    GroupDto groupEntityToDto(Group group);
    Group groupDtoToEntity(GroupDto groupDto);
}
