package com.epam.brest.motor_depot.services;

import com.epam.brest.motor_depot.dao.DriverDAO;
import com.epam.brest.motor_depot.dao.dto.DriverDTO;
import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;
import com.epam.brest.motor_depot.models.Driver;

import java.util.List;

public class DriverService implements InitAndDestroyBean {

    private final DriverDAO driverDAO;
    private final DriverDTO driverDTO;

    public DriverService(DriverDAO driverDAO, DriverDTO driverDTO) {
        this.driverDAO = driverDAO;
        this.driverDTO = driverDTO;
    }

    public List<Driver> getDriverList() {
        return driverDAO.getDriversList();
    }

    public void saveDriver(Driver driver) {
        driverDAO.saveDriverDAO(driver);
    }

    public Driver findDriverById(Integer id) {
        return driverDAO.findDriverByIdDAO(id);
    }

    public void updateDriver(Integer driver_id, Driver driver) {
        driverDAO.updateDriverDAO(driver_id, driver);
    }

    public void deleteDriver(Integer driver_id) {
        driverDAO.deleteDriverDAO(driver_id);
    }

    public Object getAvgSalary() {
        return driverDTO.getAvgSalary();
    }
}
