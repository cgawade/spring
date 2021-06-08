package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Tea {
    private String name;

    public Tea(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("Inside tea init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Inside tea destroy method");
    }
}
