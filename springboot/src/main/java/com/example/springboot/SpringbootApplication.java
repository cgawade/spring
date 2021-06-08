package com.example.springboot;

import com.example.springboot.autowired.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("Welcome to Spring Boot");

		Alien a = context.getBean(Alien.class);
		System.out.println(a.show());

	}

}
