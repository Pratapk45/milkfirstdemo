package com.Flynaut.Product.Inventory.Management.System.Exception;

import com.Flynaut.Product.Inventory.Management.System.Util.ResponceStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponceStructure<String>> idNotFoundExceptionHandler(ProductNotFoundException notFound)
    {
        ResponceStructure<String> structure = new ResponceStructure<>();
        structure.setMessage("Id Not Found ");
        structure.setStatus(HttpStatus.BAD_REQUEST.value());
        structure.setData(notFound.getMessage());

        return new ResponseEntity<>(structure ,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<String> handleInventoryNotFound(InventoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductDeletionException.class)
    public ResponseEntity<String> handleProductDeletion(ProductDeletionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<String> idNotFoundExceptionHandler(ProductNotFoundException notFound)
//    {
//       return new ResponseEntity<>(notFound.getMessage(),HttpStatus.NOT_FOUND);
//
//    }
}
