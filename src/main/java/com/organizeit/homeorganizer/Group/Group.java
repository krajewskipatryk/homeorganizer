package com.organizeit.homeorganizer.Group;

import com.organizeit.homeorganizer.Customer.Customer;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter(value = AccessLevel.PACKAGE)
@Entity
@Table(name = "groups")
public class Group {
    @Id
    private UUID id;
    private String name;
    @ManyToMany
    @JoinTable(name = "group_has_customers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> members;
}
