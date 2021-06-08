package com.example.shopping.controller;

import com.example.shopping.dao.ProductRepository;
import com.example.shopping.entities.Product;
import com.example.shopping.exceptions.ProductNotFoundException;
import com.example.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService service;

    @Autowired
    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> showProducts(){
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public Product showProduct(@PathVariable Integer id){
        return service.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
        return service.saveProduct(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletedProduct(@PathVariable Integer id){
        return service.removeProduct(id);
    }

    @DeleteMapping
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(){
        service.removeAllProduct();
    }
}
