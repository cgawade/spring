package com.springcore.constructor.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructorIngectionConfig.xml");

        Person person = (Person) context.getBean("personA");
        System.out.println(person);

        person = (Person) context.getBean("personB");
        System.out.println(person);

        person = (Person) context.getBean("personC");

        System.out.println(person);


        MathUtil mathUtil = (MathUtil) context.getBean("mathUtil");
        mathUtil.doSum();
    }
}
