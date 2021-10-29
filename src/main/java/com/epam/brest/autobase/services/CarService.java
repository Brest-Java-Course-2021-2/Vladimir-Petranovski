package com.epam.brest.autobase.services;

import com.epam.brest.autobase.dao.CarDAO;
import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Car;

import java.util.List;

public class CarService implements InitAndDestroyBean {

    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getListCar() {
        return carDAO.getListCarDAO();
    }

    public void saveCar(Car car) {
        carDAO.saveCarDAO(car);
    }

    public Car findCarById(Integer car_id) {
        return carDAO.findCarByIdDAO(car_id);
    }

    public void updateCar(Integer car_id, Car carToUpdate) {
        carDAO.updateCarDAO(car_id, carToUpdate);
    }

    public void deleteCar(Integer car_id) {
        carDAO.deleteCarDAO(car_id);
    }
}
