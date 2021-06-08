package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleConfig.xml");

        Samosa samosa = (Samosa) context.getBean("samosa");
        System.out.println("Samosa Price : "+samosa.getPrice());

        // Registering shutdown hook
        context.registerShutdownHook();

        System.out.println("------------------------------------");

        Pepsi pepsi = (Pepsi) context.getBean("pepsi");
        System.out.println("Pepsi price : "+pepsi.getPrice());


        System.out.println("------------------------------------");

        Tea tea = (Tea) context.getBean("tea");
        System.out.println("Tea Name : "+tea.getName());

    }


}
