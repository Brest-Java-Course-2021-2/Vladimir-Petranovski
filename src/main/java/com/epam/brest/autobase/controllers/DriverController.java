package com.epam.brest.autobase.controllers;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Driver;
import com.epam.brest.autobase.services.DriverService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/drivers")
public class DriverController implements InitAndDestroyBean {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping()
    public String getAllDrivers(Model model) {
        model.addAttribute("driversList", driverService.getDriverList());
        return "drivers/driver";
    }

    @GetMapping("/new-driver")
    public String newDriver(@ModelAttribute("driver") Driver driver) {
        return "drivers/new-driver";
    }

    @PostMapping()
    public String setNewPerson(@ModelAttribute("driver") Driver driver) {
        driverService.saveDriver(driver);
        return "redirect:/drivers";
    }

    @GetMapping("/{driver_id}/update")
    public String getFormForUpdateDriver(@PathVariable("driver_id") Integer driver_id, Model model) {
        model.addAttribute("driver", driverService.findDriverById(driver_id));
        return "drivers/update";
    }

    @PostMapping("/{driver_id}")
    public String updateDriver(@ModelAttribute("driver") Driver driver, @PathVariable("driver_id") Integer driver_id) {
        driverService.updateDriver(driver_id, driver);
        return "redirect:/drivers";
    }

    @GetMapping("/{driver_id}")
    public String deleteDriver(@PathVariable("driver_id") Integer driver_id) {
        driverService.deleteDriver(driver_id);
        return "redirect:/drivers";
    }
}
