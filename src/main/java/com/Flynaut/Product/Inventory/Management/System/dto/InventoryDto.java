package com.Flynaut.Product.Inventory.Management.System.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InventoryDto {

    @NotNull(message = "Product ID is required")
    private int productId;

    @Min(value = 0, message = "Quantity must be >= 0")
    private int availableQuantity;

    @NotNull(message = "Last updated time is required")
    private LocalDateTime lastUpdated;

}
