package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Product.Product;
import com.organizeit.homeorganizer.TaskType.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface TaskHistoryRepository extends JpaRepository<TaskHistory, UUID> {
    void deleteAllByCustomer(Customer customer);
    void deleteAllByProduct(Product product);
    void deleteAllByTaskType(TaskType taskType);
    List<TaskHistory> findAllByCustomer(Customer customer);
    List<TaskHistory> findAllByCustomerAndTaskType(Customer customer, TaskType taskType);
    List<TaskHistory> findAllByCustomerAndProduct(Customer customer, Product product);
    List<TaskHistory> findAllByTaskType(TaskType taskType);
    List<TaskHistory> findAllByProduct(Product product);
}
