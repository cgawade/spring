package com.springcore.collections;

import com.springcore.primitive.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        Employee employee = (Employee) applicationContext.getBean("employee");

        System.out.println(employee);

    }
}
