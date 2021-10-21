package com.epam.brest.autobase;

import com.epam.brest.autobase.controllers.CarController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            CarController carController = context.getBean("carController", CarController.class);
            System.out.println(carController.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
