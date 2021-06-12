package com.ecommerce.colab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "product_name")
    String name;
    
    @Column(name = "created_on")
    Instant createdon;

    @Column(name = "price")
    int price;

    @Column(name = "percentageDiscount")
    int percentagediscount;

    @ManyToOne
    private ProductType productType;

}
