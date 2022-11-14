package com.organizeit.homeorganizer.Product;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Getter
    private UUID id;

    @Getter
    private String name;
}
