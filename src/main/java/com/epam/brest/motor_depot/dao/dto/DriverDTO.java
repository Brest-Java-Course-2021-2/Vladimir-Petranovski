package com.epam.brest.motor_depot.dao.dto;

import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.epam.brest.motor_depot.config.JDBCConfiguration.*;
import static com.epam.brest.motor_depot.dao.Queries.*;
import static com.epam.brest.motor_depot.logger.Logging.log;

public class DriverDTO implements InitAndDestroyBean {
    public BigDecimal getAvgSalary() {
        try(Connection connection = getConnection()) {
            log.info("Connection established in " + getClass().getName());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DRIVER_AVG_SALARY);
            resultSet.next();
            BigDecimal avgSalary = resultSet.getBigDecimal("AVG(salary)");
            log.info("Value of average salary was find, it equals {}", avgSalary);
            return avgSalary;
        } catch (Exception e) {
            log.info("Value of average salary wasn't find");
            e.printStackTrace();
            return null;
        }
    }
}
