package com.epam.brest.autobase.services;

import com.epam.brest.autobase.dao.RequestDAO;
import com.epam.brest.autobase.interfaces.IInitAndDestroyBean;
import com.epam.brest.autobase.models.Request;
import org.springframework.stereotype.Service;

import java.util.List;

public class RequestService implements IInitAndDestroyBean {

    private final RequestDAO requestDAO;

    public RequestService(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public List<Request> findAllRequest() {
        return requestDAO.findAll();
    }
}
