package com.Flynaut.Product.Inventory.Management.System.service;

import com.Flynaut.Product.Inventory.Management.System.Exception.InventoryNotFoundException;
import com.Flynaut.Product.Inventory.Management.System.Exception.ProductNotFoundException;
import com.Flynaut.Product.Inventory.Management.System.dto.InventoryDto;
import com.Flynaut.Product.Inventory.Management.System.model.Inventory;
import com.Flynaut.Product.Inventory.Management.System.model.Product;
import com.Flynaut.Product.Inventory.Management.System.repository.InventoryRepo;
import com.Flynaut.Product.Inventory.Management.System.repository.ProductRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    ProductRepo productRepo;

    public Inventory addInventory(@Valid InventoryDto inventoryDto) {
        Product product = productRepo.findById(inventoryDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID " + inventoryDto.getProductId()));

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventory.setLastUpdated(LocalDateTime.now());

        return inventoryRepo.save(inventory);

    }

    public Inventory updateQuantity(  Integer id, InventoryDto inventoryDto) {
        Product product = productRepo.findById(inventoryDto.getProductId()).orElseThrow(() -> new ProductNotFoundException("Product not found with ID " + inventoryDto.getProductId()));
        Inventory inventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Inventory Not Found "));
        inventory.setProduct(product);
        inventory.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventory.setLastUpdated(LocalDateTime.now());
        return inventoryRepo.save(inventory);
    }

    public List<Inventory> viewAll() {
        return inventoryRepo.findAll();
    }
}
