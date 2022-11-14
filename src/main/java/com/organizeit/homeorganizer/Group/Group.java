package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import com.organizeit.homeorganizer.Task.HouseWork;
import com.organizeit.homeorganizer.Task.ShoppingList;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Getter
    private UUID id;

    @Getter
    private String name;

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany
    @JoinTable(name = "group_has_customers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> members = new HashSet<>();

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    @OneToOne
    private HouseWork houseWork;

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    @OneToOne
    private ShoppingList shoppingList;

    void addCustomer(Customer customer) {
        if (!members.contains(customer)) {
            this.members.add(customer);
        }
    }

    void removeCustomer(Customer customer) {
        if (members.contains(customer)) {
            this.members.remove(customer);
        }
    }

}
