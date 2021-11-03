package com.epam.brest.motor_depot.dao;

import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;
import com.epam.brest.motor_depot.models.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.motor_depot.config.JDBCConfiguration.getConnection;
import static com.epam.brest.motor_depot.dao.Queries.*;
import static com.epam.brest.motor_depot.logger.Logging.log;

public class DriverDAO implements InitAndDestroyBean {

    public List<Driver> getDriversList() {
        List<Driver> driversList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DRIVER_FIND_ALL);
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setDriver_id(resultSet.getInt("driver_id"));
                driver.setName(resultSet.getString("name"));
                driver.setDateStartWork(resultSet.getDate("date_start_work"));
                driver.setSalary(resultSet.getBigDecimal("salary"));
                driversList.add(driver);
            }
            log.info("Driver's list was create --- {}", driversList);
        } catch (Exception e) {
            log.info("Driver's list wasn't create");
            e.printStackTrace();
        }
        return driversList;
    }

    public void saveDriverDAO(Driver driver) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVER_SAVE);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setDate(2, driver.getDateStartWork());
            preparedStatement.setBigDecimal(3, driver.getSalary());
            preparedStatement.executeUpdate();
            log.info("Driver was save --- {}", driver);
        } catch (Exception e) {
            log.info("Driver wasn't save --- {}", driver);
            e.printStackTrace();
        }
    }

    public Driver findDriverByIdDAO(Integer id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVER_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Driver.builder()
                    .driver_id(resultSet.getInt("driver_id"))
                    .name(resultSet.getString("name"))
                    .dateStartWork(resultSet.getDate("date_start_work"))
                    .salary(resultSet.getBigDecimal("salary"))
                    .build();
        } catch (Exception e) {
            log.info("Driver wasn't find with id = {}", id);
            e.printStackTrace();
            return null;
        }
    }

    public void updateDriverDAO(Integer driver_id, Driver driver) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVER_UPDATE);
            preparedStatement.setInt(1, driver_id);
            preparedStatement.setString(2, driver.getName());
            preparedStatement.setDate(3, driver.getDateStartWork());
            preparedStatement.setBigDecimal(4, driver.getSalary());

            preparedStatement.executeUpdate();
            log.info("Driver {} was update with id {}", driver, driver_id);
        } catch (Exception e) {
            log.info("Driver {} wasn't update with id {}", driver, driver_id);
            e.printStackTrace();
        }
    }

    public void deleteDriverDAO(Integer driver_id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(DRIVER_DELETE);
            preparedStatement.setInt(1, driver_id);
            preparedStatement.executeUpdate();
            log.info("Driver was delete with id {}", driver_id);
        } catch (Exception e) {
            log.info("Driver wasn't delete with id {}", driver_id);
            e.printStackTrace();
        }
    }
 }
