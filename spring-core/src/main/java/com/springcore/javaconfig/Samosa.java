package com.springcore.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Samosa {
    public void checkAvialability(){
        System.out.println("available");
    }
}
