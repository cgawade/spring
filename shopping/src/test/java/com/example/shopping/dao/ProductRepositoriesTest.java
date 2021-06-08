package com.example.shopping.dao;

import com.example.shopping.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoriesTest {

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        List<Product> products = Arrays.asList(
                new Product("Football", new BigDecimal("500")),
                new Product("Hockey", new BigDecimal("2000"))
        );

        repository.saveAll(products);
    }

    @Test
    public void autowiredWorking(){
        assertNotNull(repository);
    }

    @Test
    public void getCount(){
        System.out.println(repository.findAll());
        assertEquals(2, repository.count());
    }

    @Test
    public void findById(){
        Optional<Product> product = repository.findById(1);
        assertTrue(product.isPresent());
    }

    @Test
    public void deleteById(){
        repository.deleteById(1);
        Optional<Product> product = repository.findById(1);
        assertFalse(product.isPresent());
    }
}
