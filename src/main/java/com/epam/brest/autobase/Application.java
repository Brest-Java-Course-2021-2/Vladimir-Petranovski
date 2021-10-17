package com.epam.brest.autobase;

import com.epam.brest.autobase.controllers.CarController;
import com.epam.brest.autobase.dao.models.Car;
import com.epam.brest.autobase.dao.models.Driver;
import com.epam.brest.autobase.dao.models.Request;
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
