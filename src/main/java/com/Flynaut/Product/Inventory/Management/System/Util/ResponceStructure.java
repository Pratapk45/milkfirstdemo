package com.Flynaut.Product.Inventory.Management.System.Util;

import lombok.Data;

@Data
public class ResponceStructure<T> {
    private String message;
    private int status;
    private T data;
}
