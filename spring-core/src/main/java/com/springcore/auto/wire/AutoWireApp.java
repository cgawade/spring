package com.springcore.auto.wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autoWireconfig.xml");

        Employee emp = (Employee) context.getBean("emp");

        System.out.println(emp);


        System.out.println("--------------------------");

        emp =(Employee) context.getBean("emp1");
        System.out.println(emp);

        System.out.println("--------------------------");
        emp =(Employee) context.getBean("emp2");
        System.out.println(emp);


        System.out.println("--------------------------");
        emp =(Employee) context.getBean("emp3");
        System.out.println(emp);
    }

}
