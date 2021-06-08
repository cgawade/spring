package com.example.shopping.config;

import com.example.shopping.dao.ProductRepository;
import com.example.shopping.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class AppInit implements CommandLineRunner {

    private final ProductRepository repository;

    @Autowired
    public AppInit(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0){
            List<Product> products = Arrays.asList(new Product("Bat",new BigDecimal("1500")),
                                        new Product("Football", new BigDecimal("500")),
                                        new Product("Hockey", new BigDecimal("2000")));

            repository.saveAll(products);
        }
    }
}
