package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("standaloneCollectionconfig.xml");

        Person person = context.getBean("person1", Person.class);
        System.out.println(person);
    }
}
