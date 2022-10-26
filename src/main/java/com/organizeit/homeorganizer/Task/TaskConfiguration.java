package com.organizeit.homeorganizer.Task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskConfiguration {

    @Bean
    TaskService taskService() {
        return new TaskService();
    }

    @Bean
    TaskTypeService taskTypeService(TaskTypeRepository taskTypeRepository, TaskTypeMapper taskTypeMapper) {
        return new TaskTypeService(taskTypeMapper, taskTypeRepository);
    }

    @Bean
    TaskHistory taskHistory() {
        return new TaskHistory();
    }

    @Bean
    ProductService productService(ProductRepository productRepository, ProductMapper productMapper) {
        return new ProductService(productRepository, productMapper);
    }

    @Bean
    HouseWorkService houseWorkService() {
        return new HouseWorkService();
    }

    @Bean
    ShoppingListService shoppingListService() {
        return new ShoppingListService();
    }

    @Bean
    TaskFacade taskFacade(HouseWorkService houseWorkService,
                          ProductService productService,
                          ShoppingListService shoppingListService,
                          TaskService taskService,
                          TaskTypeService taskTypeService) {
        return new TaskFacade(houseWorkService, productService, shoppingListService, taskService, taskTypeService);
    }
}
