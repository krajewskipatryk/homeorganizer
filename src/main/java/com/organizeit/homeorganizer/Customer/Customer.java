package com.organizeit.homeorganizer.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.organizeit.homeorganizer.Group.Group;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter(value = AccessLevel.PACKAGE)
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private Set<Group> groups;
}
