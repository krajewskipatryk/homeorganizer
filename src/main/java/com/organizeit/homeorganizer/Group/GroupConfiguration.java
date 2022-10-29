package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Task.TaskFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GroupConfiguration {
    @Bean
    GroupService groupService(GroupRepository groupRepository, GroupMapper groupMapper) {
        return new GroupService(groupRepository, groupMapper);
    }

    @Bean
    GroupFacade groupFacade(GroupService groupService, GroupMapper groupMapper, CustomerFacade customerFacade, TaskFacade taskFacade) {
        return new GroupFacade(groupService, customerFacade, groupMapper, taskFacade);
    }
}
