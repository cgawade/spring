package com.example.springboot.autowired;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private int id;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void compile(){
        System.out.println("Compiling");
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", price='" + price + '\'' +
                '}';
    }
}
