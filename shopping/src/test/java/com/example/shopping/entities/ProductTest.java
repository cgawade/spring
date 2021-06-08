package com.example.shopping.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class ProductTest {
    @Autowired
    private Validator validator;

    @Test
    public void validatorNotNull(){
        assertNotNull(validator);
        System.out.println(validator.getClass().getName());
    }

    @Test
    public void productWithNullNameIsNotVslid(){
        Product p = new Product();
        p.setPrice(BigDecimal.TEN);

        Set<ConstraintViolation<Product>> violations = validator.validate(p);
        assertEquals(1, violations.size());
        System.out.println(violations);
    }
}
