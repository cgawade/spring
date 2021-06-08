package com.example.shopping.service;

import com.example.shopping.dao.ProductRepository;
import com.example.shopping.entities.Product;
import com.example.shopping.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductService.class.getName());
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }

    public ResponseEntity<Product> saveProduct(Product product){
        Product p = repository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(p.getId())
                .toUri();

        logger.info("Location URI : "+ location);
        logger.info("Response *** "+ResponseEntity.created(location).body(p));
        return ResponseEntity.created(location).body(p);
    }

    public ResponseEntity<Void> removeProduct(Integer productId){
        Optional<Product> product = repository.findById(productId);
        if(product.isPresent()){
            repository.deleteById(productId);
            logger.info("Product deleted : "+product);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public void removeAllProduct(){
        repository.deleteAllInBatch();
    }
}
