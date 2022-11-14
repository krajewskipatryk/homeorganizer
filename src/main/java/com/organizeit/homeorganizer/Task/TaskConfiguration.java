package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Product.ProductService;
import com.organizeit.homeorganizer.TaskType.TaskTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskConfiguration {

    @Bean
    TaskHistoryService taskHistoryService(TaskHistoryRepository taskHistoryRepository) {
        return new TaskHistoryService(taskHistoryRepository);
    }

    @Bean
    HouseWorkService houseWorkService(HouseWorkRepository houseWorkRepository) {
        return new HouseWorkService(houseWorkRepository);
    }

    @Bean
    ShoppingListService shoppingListService(ShoppingListRepository shoppingListRepository) {
        return new ShoppingListService(shoppingListRepository);
    }

    @Bean
    TaskFacade taskFacade(HouseWorkService houseWorkService,
                          ProductService productService,
                          ShoppingListService shoppingListService,
                          TaskTypeService taskTypeService,
                          TaskHistoryService taskHistoryService,
                          CustomerFacade customerFacade) {
        return new TaskFacade(houseWorkService, productService, shoppingListService, taskTypeService, taskHistoryService, customerFacade);
    }
}
