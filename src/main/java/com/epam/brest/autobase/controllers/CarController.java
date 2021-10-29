package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Car;
import com.epam.brest.autobase.services.CarService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cars")
public class CarController implements InitAndDestroyBean {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String getAllCar(Model model) {
        model.addAttribute("carList", carService.getListCar());
        return "cars/car";
    }

    @GetMapping("/new-car")
    public String showFormAddCar(@ModelAttribute("car") Car car) {
        return "cars/new-car";
    }

    @PostMapping()
    public String addCar(@ModelAttribute("car") Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/{car_id}/update")
    public String showFormForUpdateCar(@PathVariable("car_id") Integer car_id, Model model) {
        model.addAttribute("car", carService.findCarById(car_id));
        return "cars/update-car";
    }

    @PostMapping("/{car_id}")
    public String updateCar(@ModelAttribute("car") Car car, @PathVariable("car_id") Integer car_id) {
        carService.updateCar(car_id, car);
        return "redirect:/cars";
    }

    @GetMapping("/{car_id}")
    public String deleteCar(@PathVariable("car_id") Integer car_id) {
        carService.deleteCar(car_id);
        return "redirect:/cars";
    }
}
