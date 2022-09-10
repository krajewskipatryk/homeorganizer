package com.organizeit.homeorganizer.Product.Api.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    private String id;
    private String name;
}
