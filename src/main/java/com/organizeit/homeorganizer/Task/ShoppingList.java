package com.organizeit.homeorganizer.Task;

import com.organizeit.homeorganizer.Group.Group;
import com.organizeit.homeorganizer.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @Getter
    private UUID id;

    @Getter
    @OneToOne
    private Group group;

    @Getter
    @OneToMany
    private Set<TaskHistory> taskHistory;

    @Getter
    @OneToMany
    private Set<Product> products;
}
