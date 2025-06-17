package com.Flynaut.Product.Inventory.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int availableQuantity;
    private LocalDateTime lastUpdated;

    @OneToOne
    private Product product;
}
