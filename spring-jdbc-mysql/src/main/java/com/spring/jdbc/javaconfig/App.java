package com.spring.jdbc.javaconfig;

import com.spring.jdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student();
//
//        student.setId(19);
//
//        System.out.println("No of recors inserted " + studentDao.remove(student));


//        System.out.println(studentDao.getStudent(14));

//        System.out.println(studentDao.getStudents());

        studentDao.getStudents().stream().forEach(System.out::println);

    }
}
