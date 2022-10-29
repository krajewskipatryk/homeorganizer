package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Product.Product;
import com.organizeit.homeorganizer.TaskType.TaskType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Table(name = "task_history")
public class TaskHistory {
    @Id
    @Getter
    private UUID id;

    @Getter
    @CreatedDate
    private LocalDate taskCompletionDate;

    @Getter
    @ManyToOne
    private Customer customer;

    @ManyToOne
    @Nullable
    @Getter
    private Product product;

    @ManyToOne
    @Nullable
    @Getter
    private TaskType taskType;

    public TaskHistory(UUID id, LocalDate taskCompletionDate, Customer customer, @Nullable Product product) {
        this.id = id;
        this.taskCompletionDate = taskCompletionDate;
        this.customer = customer;
        this.product = product;
    }

    public TaskHistory(UUID id, LocalDate taskCompletionDate, Customer customer, @Nullable TaskType taskType) {
        this.id = id;
        this.taskCompletionDate = taskCompletionDate;
        this.customer = customer;
        this.taskType = taskType;
    }
}
