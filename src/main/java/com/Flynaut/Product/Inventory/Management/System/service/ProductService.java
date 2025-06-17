package com.Flynaut.Product.Inventory.Management.System.service;

import com.Flynaut.Product.Inventory.Management.System.Exception.ProductNotFoundException;
import com.Flynaut.Product.Inventory.Management.System.Util.ResponceStructure;
import com.Flynaut.Product.Inventory.Management.System.dto.ProductDto;
import com.Flynaut.Product.Inventory.Management.System.model.Product;
import com.Flynaut.Product.Inventory.Management.System.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<ResponceStructure<Product>> addProduct(ProductDto productDto) {

        ResponceStructure<Product> structure = new ResponceStructure<>();
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setUnit(productDto.getUnit());
        product.setCategory(productDto.getCategory());

        structure.setMessage("save Product successfully");
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setData(productRepo.save(product));
        return new ResponseEntity(structure ,HttpStatus.CREATED);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {

        Optional<Product> optional = productRepo.findById(id);

        if (optional.isPresent()) {
            Product product=optional.get();
            return product;
        }else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }

    }

    public Product updateProduct(Integer id, ProductDto productDto) {

        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found with id : "+id));


        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setUnit(productDto.getUnit());
       return productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        Optional<Product> optional = productRepo.findById(id);

        if (optional.isPresent()){
             productRepo.deleteById(id);
        }else {
            throw new ProductNotFoundException("Cannot delete. Product not found with ID: " + id);
        }
    }
}
