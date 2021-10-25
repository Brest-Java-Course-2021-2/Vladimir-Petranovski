package com.epam.brest.autobase.services;

import com.epam.brest.autobase.dao.RequestDAO;
import com.epam.brest.autobase.interfaces.InitAndDestroyBean;
import com.epam.brest.autobase.models.Request;

import java.util.List;

public class RequestService implements InitAndDestroyBean {

    private final RequestDAO requestDAO;

    public RequestService(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public List<Request> findAllRequest() {
        return requestDAO.findAll();
    }
}
