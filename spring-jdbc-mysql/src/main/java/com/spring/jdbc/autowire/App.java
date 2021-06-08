package com.spring.jdbc.autowire;

import com.spring.jdbc.autowire.dao.EmployeeDao;
import com.spring.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);

        employeeDao.getEmployees().stream().forEach(System.out::println);

    }
}
