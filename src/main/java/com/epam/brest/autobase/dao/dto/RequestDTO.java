package com.epam.brest.autobase.dao.dto;

import com.epam.brest.autobase.dao.Queries;
import com.epam.brest.autobase.interfaces.InitAndDestroyBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.epam.brest.autobase.config.JDBCConfiguration.getConnection;
import static com.epam.brest.autobase.logger.Logging.log;

public class RequestDTO implements InitAndDestroyBean {

//    public String getNameDriverById(Integer id) {
//        try(Connection connection = getConnection()) {
//            log.info("Connection established in " + getClass().getName());
//            PreparedStatement preparedStatement = connection.prepareStatement(Queries.DRIVER_FIND_NAME_DRIVER_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            log.info("Name of driver was find by request_id equals {}", id);
//            return resultSet.getString("name");
//        } catch (Exception e) {
//            log.info("Name of driver was find by request_id equals {}", id);
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public Integer getCountCarsForDriver() {
//        return null;
//    }
}
