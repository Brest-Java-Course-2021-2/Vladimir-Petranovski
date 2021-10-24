package com.epam.brest.autobase.dao;

import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import com.epam.brest.autobase.models.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.autobase.config.JDBCConfiguration.getConnection;
import static com.epam.brest.autobase.dao.Queries.REQUEST_FIND_ALL;
import static com.epam.brest.autobase.logger.MyLogger.log;

public class RequestDAO implements IInitAndDestroyBean {

    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = getConnection()) {
            log.info("Connection established");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(REQUEST_FIND_ALL);
            while (resultSet.next()) {
                Request request = new Request();
                request.setId((resultSet.getInt("id")));
                request.setName(resultSet.getString("name"));
                request.setDriver_id(resultSet.getInt("driver_id"));
                requests.add(request);
                log.info("Request's list was create --- {}", requests);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            log.info("Request's list wasn't create");
            throwables.printStackTrace();
        }
        return requests;
    }
}