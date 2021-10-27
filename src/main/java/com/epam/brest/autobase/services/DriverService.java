package com.epam.brest.autobase.services;

import com.epam.brest.autobase.dao.DriverDAO;
import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Driver;

import java.util.List;

public class DriverService implements InitAndDestroyBean {

    private final DriverDAO driverDAO;

    public DriverService(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
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
}
