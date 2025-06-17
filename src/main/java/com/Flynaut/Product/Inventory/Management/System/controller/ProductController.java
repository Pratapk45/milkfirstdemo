package com.Flynaut.Product.Inventory.Management.System.controller;

import com.Flynaut.Product.Inventory.Management.System.Util.ResponceStructure;
import com.Flynaut.Product.Inventory.Management.System.dto.ProductDto;
import com.Flynaut.Product.Inventory.Management.System.model.Product;
import com.Flynaut.Product.Inventory.Management.System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ResponceStructure<Product>> addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
         return ResponseEntity.ok(productService.getAllProducts());
       // return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
       productService.deleteProduct(id);
       return ResponseEntity.ok("Product Deleted Successfully");
    }

}
