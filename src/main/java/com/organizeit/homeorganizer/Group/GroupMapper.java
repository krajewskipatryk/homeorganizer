package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Group.Dto.GroupCustomersResponse;
import com.organizeit.homeorganizer.Group.Dto.GroupDto;
import com.organizeit.homeorganizer.Group.Dto.GroupRequestData;
import com.organizeit.homeorganizer.Group.Dto.GroupResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface GroupMapper {
    GroupResponse groupDtoToResponse(GroupDto groupDto);
    GroupCustomersResponse groupEntityToUsersResponse(Group group);
    GroupDto groupEntityToDto(Group group);
    Group groupDtoToEntity(GroupDto groupDto);
    GroupResponse groupEntityToResponse(Group group);
}
