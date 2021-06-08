package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReferenceApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("referenceConfig.xml");

        A aref = (A) applicationContext.getBean("aref");

        System.out.println(aref);
    }
}
