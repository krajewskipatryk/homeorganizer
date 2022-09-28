package com.organizeit.homeorganizer.Task;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskFacade {
    private final HouseWorkService houseWorkService;
    private final ProductService productService;
    private final ShoppingListService shoppingListService;
    private final TaskService taskService;
    private final TaskTypeService taskTypeService;
}
