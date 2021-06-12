package com.ecommerce.colab.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
@Data
@Builder
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    String name;


    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private Set<Product> products;


}
