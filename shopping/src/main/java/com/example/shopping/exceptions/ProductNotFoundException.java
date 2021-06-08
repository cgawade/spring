package com.example.shopping.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException() {
        this("Product not found");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Integer id) {
        this("Product "+ id +" not found");
    }
}
