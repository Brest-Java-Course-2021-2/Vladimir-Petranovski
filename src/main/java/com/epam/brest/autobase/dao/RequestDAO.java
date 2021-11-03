package com.epam.brest.autobase.dao;

import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.autobase.config.JDBCConfiguration.getConnection;
import static com.epam.brest.autobase.dao.Queries.*;
import static com.epam.brest.autobase.logger.Logging.log;

public class RequestDAO implements InitAndDestroyBean {

    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = getConnection()) {
            log.info("Connection established " + getClass().getName());
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

    public void saveRequestDAO(Request request) {
        try(Connection connection = getConnection()) {
            log.info("Connection established " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_SAVE);
            preparedStatement.setString(1, request.getName());
            preparedStatement.setInt(2, request.getDriver_id());
            preparedStatement.executeUpdate();
            log.info("Request was save --- {}", request);
        } catch (Exception e) {
            log.info("Request wasn't save --- {}", request);
            e.printStackTrace();
        }
    }

    public Request findRequestByIdDAO(Integer request_id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_FIND_BY_ID);
            preparedStatement.setInt(1, request_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return Request.builder()
                    .request_id(resultSet.getInt("request_id"))
                    .name(resultSet.getString("name"))
                    .driver_id(resultSet.getInt("driver_id"))
                    .build();
        } catch(Exception e) {
            log.info("Request wasn't find by id --- {}", request_id);
            e.printStackTrace();
            return null;
        }
    }

    public void updateRequestDAO(Integer request_id, Request requestToUpdate) {
        try(Connection connection = getConnection()) {
            log.info("Connection established " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_UPDATE);
            preparedStatement.setInt(1, request_id);
            preparedStatement.setString(2, requestToUpdate.getName());
            preparedStatement.setInt(3, requestToUpdate.getDriver_id());
            preparedStatement.executeUpdate();
            log.info("Request {} was update with id {}", requestToUpdate, request_id);
        } catch (Exception e) {
            log.info("Request {} wasn't update with id {}", requestToUpdate, request_id);
            e.printStackTrace();
        }
    }

    public void deleteRequestDAO(Integer request_id) {
        try(Connection connection = getConnection()) {
            log.info("Connection established " + getClass().getName());
            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST_DELETE);
            preparedStatement.setInt(1, request_id);
            preparedStatement.executeUpdate();
            log.info("Request was delete with id {}", request_id);
        } catch (Exception e) {
            log.info("Request wasn't update with id {}", request_id);
            e.printStackTrace();
        }
    }
}
