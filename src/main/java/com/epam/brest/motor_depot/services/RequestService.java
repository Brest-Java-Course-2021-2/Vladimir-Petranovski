package com.epam.brest.motor_depot.services;

import com.epam.brest.motor_depot.dao.RequestDAO;
import com.epam.brest.motor_depot.dao.dto.RequestDTO;
import com.epam.brest.motor_depot.interfaces.InitAndDestroyBean;
import com.epam.brest.motor_depot.models.Request;

import java.util.List;

public class RequestService implements InitAndDestroyBean {

    private final RequestDAO requestDAO;
    public final RequestDTO requestDTO; //TODO don't forget

    public RequestService(RequestDAO requestDAO, RequestDTO requestDTO) {
        this.requestDAO = requestDAO;
        this.requestDTO = requestDTO;
    }

    public List<Request> findAllRequest() {
        return requestDAO.findAll();
    }

    public void saveRequest(Request request) {
        requestDAO.saveRequestDAO(request);
    }

    public Request findRequestById(Integer request_id) {
        return requestDAO.findRequestByIdDAO(request_id);
    }

    public void updateRequest(Integer request_id, Request requestToUpdate) {
        requestDAO.updateRequestDAO(request_id, requestToUpdate);
    }

    public void deleteRequest(Integer request_id) {
        requestDAO.deleteRequestDAO(request_id);
    }

//    public String getNameDriverById(Integer request_id) {
//        return requestDTO.getNameDriverById(request_id);
//    }
}
