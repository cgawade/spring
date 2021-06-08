package com.springcore.primitive;

import com.springcore.primitive.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config2.xml");

        Student student1 = (Student) applicationContext.getBean("student1");
        System.out.println(student1);

        Student student2 = (Student) applicationContext.getBean("student2");
        System.out.println(student2);

    }
}
