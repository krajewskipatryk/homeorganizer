package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Product.Product;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;

    public TaskHistory createTaskHistoryForShoppingList(Product product, Customer customer) {
        TaskHistory taskHistory = new TaskHistory(UUID.randomUUID(), LocalDate.now(), customer, product);

        return taskHistoryRepository.save(taskHistory);
    }

    public TaskHistory createTaskHistoryForHouseWork(TaskType taskType, Customer customer) {
        TaskHistory taskHistory = new TaskHistory(UUID.randomUUID(), LocalDate.now(), customer, taskType);

        return taskHistoryRepository.save(taskHistory);
    }

    public List<TaskHistory> getTaskHistoryByCustomer(Customer customer) {
        return taskHistoryRepository.findAllByCustomer(customer);
    }

    public List<TaskHistory> getTaskHistoryByProduct(Product product) {
        return taskHistoryRepository.findAllByProduct(product);
    }

    public List<TaskHistory> getTaskHistoryByTaskType(TaskType taskType) {
        return taskHistoryRepository.findAllByTaskType(taskType);
    }

    public List<TaskHistory> getTaskHistoryByCustomerAndTaskType(Customer customer, TaskType taskType) {
        return taskHistoryRepository.findAllByCustomerAndTaskType(customer, taskType);
    }

    public List<TaskHistory> getTaskHistoryByCustomerAndProduct(Customer customer, Product product) {
        return taskHistoryRepository.findAllByCustomerAndProduct(customer, product);
    }

    public void deleteTaskHistory(UUID id) {
        taskHistoryRepository.delete(this.getTaskHistoryEntity(id));
    }

    public void deleteAllTaskHistoryByCustomer(Customer customer) {
        taskHistoryRepository.deleteAllByCustomer(customer);
    }

    public void deleteAllTaskHistoryByProduct(Product product) {
        taskHistoryRepository.deleteAllByProduct(product);
    }

    public void deleteAllTaskHistoryByTaskType(TaskType taskType) {
        taskHistoryRepository.deleteAllByTaskType(taskType);
    }

    public TaskHistory getTaskHistoryEntity(UUID id) {
        return taskHistoryRepository.findById(id).orElseThrow(() -> {
           throw new RuntimeException("ni ma");
        });
    }
}
