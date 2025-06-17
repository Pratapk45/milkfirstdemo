package com.Flynaut.Product.Inventory.Management.System.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private String description;
    private Double price;
    private String category;
    private String unit;
}
