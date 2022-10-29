package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Customer.CustomerFacade;
import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Product.Product;
import com.organizeit.homeorganizer.Product.ProductService;
import com.organizeit.homeorganizer.TaskType.TaskType;
import com.organizeit.homeorganizer.TaskType.TaskTypeService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TaskFacade {
    private final HouseWorkService houseWorkService;
    private final ProductService productService;
    private final ShoppingListService shoppingListService;
    private final TaskTypeService taskTypeService;
    private final TaskHistoryService taskHistoryService;
    private final CustomerFacade customerFacade;

    public HouseWork createHouseWork(Group group) {
        return houseWorkService.createHouseWork(group);
    }
    public ShoppingList createShoppingList(Group group) {
        return shoppingListService.createShoppingList(group);
    }
    public void addTaskType(String taskName, UUID houseWorkId) {
        HouseWork houseWork = houseWorkService.getHouseWorkEntity(houseWorkId);
        TaskType taskType = taskTypeService.createTaskType(taskName);

        houseWork.getTaskList().add(taskType);

        houseWorkService.updateHouseWorkStatus(houseWork);
    }
    public void addProduct(String productName, UUID shoppingListId) {
        ShoppingList shoppingList = shoppingListService.getShoppingListEntity(shoppingListId);
        Product product = productService.createProduct(productName);

        shoppingList.getProducts().add(product);

        shoppingListService.updateShoppingListStatus(shoppingList);
    }

    public List<TaskHistory> getTaskHistoryForCustomer(UUID customerId) {
        return taskHistoryService.getTaskHistoryByCustomer(customerFacade.getCustomerEntity(customerId));
    }
    public List<TaskHistory> getTaskHistoryForTaskType(UUID taskTypeId) {
        return taskHistoryService.getTaskHistoryByTaskType(taskTypeService.getTaskTypeEntity(taskTypeId));
    }
    public List<TaskHistory> getTaskHistoryForCustomerAndTaskType(UUID customerId, UUID taskTypeId) {
        return taskHistoryService.getTaskHistoryByCustomerAndTaskType(customerFacade.getCustomerEntity(customerId), taskTypeService.getTaskTypeEntity(taskTypeId));
    }
    public List<TaskHistory> getShoppingListHistoryForProduct(UUID productId) {
        return taskHistoryService.getTaskHistoryByProduct(productService.getProductEntity(productId));
    }
    public List<TaskHistory> getShoppingListHistoryForCustomerAndProduct(UUID customerId, UUID productId) {
        return taskHistoryService.getTaskHistoryByCustomerAndProduct(customerFacade.getCustomerEntity(customerId), productService.getProductEntity(productId));
    }
    public void addPerformedTask(UUID taskTypeId, UUID customerId) {
        Customer customer = customerFacade.getCustomerEntity(customerId);
        TaskType taskType = taskTypeService.getTaskTypeEntity(taskTypeId);

        TaskHistory taskHistory = taskHistoryService.createTaskHistoryForHouseWork(taskType, customer);

        customerFacade.addTaskHistory(customer, taskHistory);
    }
    public void addBoughtProduct(UUID productId, UUID customerId) {
        Customer customer = customerFacade.getCustomerEntity(customerId);
        Product product = productService.getProductEntity(productId);

        TaskHistory taskHistory = taskHistoryService.createTaskHistoryForShoppingList(product, customer);

        customerFacade.addTaskHistory(customer, taskHistory);
    }
}
