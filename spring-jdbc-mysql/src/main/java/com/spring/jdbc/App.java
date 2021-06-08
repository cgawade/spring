package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbconfig.xml");

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
