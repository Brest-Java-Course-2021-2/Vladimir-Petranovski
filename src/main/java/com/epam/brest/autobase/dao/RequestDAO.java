package com.epam.brest.autobase.dao;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.autobase.config.JDBCConfiguration.getConnection;
import static com.epam.brest.autobase.dao.Queries.REQUEST_FIND_ALL;
import static com.epam.brest.autobase.logger.Logging.log;

public class RequestDAO implements InitAndDestroyBean {

    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = getConnection()) {
            log.info("Connection established");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(REQUEST_FIND_ALL);
            while (resultSet.next()) {
                Request request = new Request();
                request.setRequest_id((resultSet.getInt("request_id")));
                request.setName(resultSet.getString("name"));
                request.setDriver_id(resultSet.getInt("driver_id"));
                requests.add(request);
            }
            log.info("Request's list was create --- {}", requests);
        } catch (SQLException | ClassNotFoundException throwables) {
            log.info("Request's list wasn't create");
            throwables.printStackTrace();
        }
        return requests;
    }
}
