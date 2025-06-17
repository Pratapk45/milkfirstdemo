package com.Flynaut.Product.Inventory.Management.System.controller;

import com.Flynaut.Product.Inventory.Management.System.dto.InventoryDto;
import com.Flynaut.Product.Inventory.Management.System.model.Inventory;
import com.Flynaut.Product.Inventory.Management.System.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("/save")
    public ResponseEntity<Inventory> addInventory( @RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.addInventory(inventoryDto));
    }
    @PutMapping("/{id}")
    public Inventory update(@PathVariable  Integer id ,@RequestBody InventoryDto inventoryDto) {
        return inventoryService.updateQuantity(id, inventoryDto);
    }
    @GetMapping("/getAllInventory")
    public ResponseEntity<List<Inventory>> viewAllInventory(){
        return ResponseEntity.ok(inventoryService.viewAll());
    }


}
