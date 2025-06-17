package com.Flynaut.Product.Inventory.Management.System.repository;

import com.Flynaut.Product.Inventory.Management.System.model.Inventory;
import com.Flynaut.Product.Inventory.Management.System.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepo extends JpaRepository<Inventory , Integer> {

}
