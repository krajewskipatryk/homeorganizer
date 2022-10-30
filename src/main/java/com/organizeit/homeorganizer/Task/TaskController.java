package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Product.Dto.ProductRequestData;
import com.organizeit.homeorganizer.TaskType.Dto.TaskTypeRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
class TaskController {
    private final TaskFacade taskFacade;
    @PostMapping(path = "/housework/{houseWorkId}/tasktype/add")
    public void addTaskType(@PathVariable UUID houseWorkId, @RequestBody TaskTypeRequestData taskTypeData) {
        taskFacade.addTaskType(taskTypeData.getName(), houseWorkId);
    }

    @PostMapping(path = "/shoppinglist/{shoppingListId}/product/add")
    public void addProduct(@PathVariable UUID shoppingListId, @RequestBody ProductRequestData productData) {
        taskFacade.addProduct(productData.getName(), shoppingListId);
    }

    @PostMapping(path = "/housework/task/{taskTypeId}/customer/{customerId}/perform")
    public void addPerformedTask(@PathVariable UUID taskTypeId, @PathVariable UUID customerId) {
        taskFacade.addPerformedTask(taskTypeId, customerId);
    }

    @PostMapping(path = "/shoppinglist/product/{productId}/customer/{customerId}/perform")
    public void addBoughtProduct(@PathVariable UUID productId, @PathVariable UUID customerId) {
        taskFacade.addBoughtProduct(productId, customerId);
    }

    @GetMapping(path = "/customer/{customerId}/history")
    public List<TaskHistory> getTaskHistoryForCustomer(@PathVariable UUID customerId) {
        return taskFacade.getTaskHistoryForCustomer(customerId);
    }

    @GetMapping(path = "/taskType/{taskTypeId}/history")
    public List<TaskHistory> getTaskHistoryForTaskType(@PathVariable UUID taskTypeId) {
        return taskFacade.getTaskHistoryForTaskType(taskTypeId);
    }

    @GetMapping(path = "/customer/{customerId}/taskType/{taskTypeId}/history")
    public List<TaskHistory> getTaskHistoryForCustomerAndTaskType(@PathVariable UUID customerId, @PathVariable UUID taskTypeId) {
        return taskFacade.getTaskHistoryForCustomerAndTaskType(customerId, taskTypeId);
    }

    @GetMapping(path = "/product/{productId}/history")
    public List<TaskHistory> getShoppingListHistoryForProduct(@PathVariable UUID productId) {
        return taskFacade.getShoppingListHistoryForProduct(productId);
    }

    @GetMapping(path = "customer/{customerId}/product/{productId}/history")
    public List<TaskHistory> getShoppingListHistoryForCustomerAndProduct(@PathVariable UUID customerId, @PathVariable UUID productId) {
        return taskFacade.getShoppingListHistoryForCustomerAndProduct(customerId, productId);
    }
}
