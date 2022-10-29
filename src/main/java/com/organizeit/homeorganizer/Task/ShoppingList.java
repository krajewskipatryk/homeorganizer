package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Product.Product;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppingList extends Task {
    @Getter
    @OneToMany
    private Set<Product> products;
    public ShoppingList(@NonNull UUID id, @NonNull Group group, Set<TaskHistory> taskHistory, Set<Product> products) {
        super(id, group, taskHistory);
        this.products = products;
    }
}
