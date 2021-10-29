package com.epam.brest.autobase.dao;

import com.epam.brest.autobase.config.JDBCConfiguration;
import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.autobase.config.JDBCConfiguration.*;
import static com.epam.brest.autobase.dao.Queries.*;
import static com.epam.brest.autobase.logger.Logging.log;

public class CarDAO implements InitAndDestroyBean {

    public List<Car> getListCarDAO() {
        List<Car> carList = new ArrayList<>();
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(CAR_FIND_ALL);
            while (resultSet.next()) {
                Car car = Car.builder()
                        .car_id(resultSet.getInt("car_id"))
                        .model(resultSet.getString("model"))
                        .driver_id(resultSet.getInt("driver_id"))
                        .build();
                carList.add(car);
            }
            log.info("Car's list was create --- {}", carList);
        } catch (Exception e) {
            log.info("Car's list wasn't create");
            e.printStackTrace();
        }
        return carList;
    }

    public void saveCarDAO(Car car) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(CAR_SAVE);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getDriver_id());
            preparedStatement.executeUpdate();
            log.info("Car was save --- {}", car);
        }catch (Exception e) {
            log.info("Car was save --- {}", car);
            e.printStackTrace();
        }
    }

    public Car findCarByIdDAO(Integer car_id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(CAR_FIND_BY_ID);
            preparedStatement.setInt(1, car_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Car.builder()
                    .car_id(resultSet.getInt("car_id"))
                    .model(resultSet.getString("model"))
                    .driver_id(resultSet.getInt("driver_id"))
                    .build();
        } catch (Exception e) {
            log.info("Car wasn't find by car_id equals {}", car_id);
            e.printStackTrace();
            return null;
        }
    }

    public void updateCarDAO(Integer car_id, Car carToUpdate) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(CAR_UPDATE);
            preparedStatement.setInt(1, car_id);
            preparedStatement.setString(2, carToUpdate.getModel());
            preparedStatement.setInt(3, carToUpdate.getDriver_id());
            preparedStatement.executeUpdate();
            log.info("Car was update by car_id equals {}", car_id);
        } catch (Exception e) {
            log.info("Car wasn't update by car_id equals {}", car_id);
            e.printStackTrace();
        }
    }

    public void deleteCarDAO(Integer car_id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(CAR_DELETE);
            preparedStatement.setInt(1, car_id);
            preparedStatement.executeUpdate();
            log.info("Car was delete by car_id equals {}", car_id);
        } catch (Exception e) {
            log.info("Car was delete by car_id equals {}", car_id);
            e.printStackTrace();
        }
    }
}
