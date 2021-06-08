package com.springcore.auto.wire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autoWireAnnotationConfig.xml");

        Employee emp = (Employee) context.getBean("emp");

        System.out.println(emp);

    }

}
