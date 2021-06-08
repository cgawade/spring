package com.springcore.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spelConfig.xml");

        Salary salary = context.getBean("salary", Salary.class);

        System.out.println(salary);

    }
}
