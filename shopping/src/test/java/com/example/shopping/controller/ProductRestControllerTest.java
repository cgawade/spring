package com.example.shopping.controller;

import com.example.shopping.entities.Product;
import com.example.shopping.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(ProductRestController.class)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    private final List<Product> products = Arrays.asList(
            new Product(1,"baseball", new BigDecimal(9.99)),
            new Product(2, "football", new BigDecimal(14.95)),
            new Product(3, "basketball", new BigDecimal(11.99))
    );

    @BeforeEach
    void setUp(){
        Mockito.when(service.getAllProducts()).thenReturn(products);
        Mockito.when(service.getProductById(1)).thenReturn(products.get(0));
    }

    @Test
    public void getAllProducts() throws Exception{

    }
}
