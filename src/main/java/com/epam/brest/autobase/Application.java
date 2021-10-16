package com.epam.brest.autobase;

import com.epam.brest.autobase.dao.models.Car;
import com.epam.brest.autobase.dao.models.Driver;
import com.epam.brest.autobase.dao.models.Request;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Car car = context.getBean(Car.class);
            Driver driver = context.getBean(Driver.class);
            Request request = context.getBean(Request.class);
            System.out.println(car.getModel());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
